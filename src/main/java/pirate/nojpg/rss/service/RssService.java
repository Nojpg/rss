package pirate.nojpg.rss.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import pirate.nojpg.rss.dto.Feed;
import pirate.nojpg.rss.dto.FeedMessage;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Service
public class RssService {
    static final String TITLE = "title";
    static final String DESCRIPTION = "description";
    static final String CHANNEL = "channel";
    static final String LANGUAGE = "language";
    static final String COPYRIGHT = "copyright";
    static final String LINK = "link";
    static final String AUTHOR = "author";
    static final String ITEM = "item";
    static final String PUB_DATE = "pubDate";
    static final String GUID = "guid";

    @SneakyThrows
    public static Feed test(URL url) {
        boolean isFeedHeader = true;
        Feed feed = null;
        String description = "";
        String title = "";
        String link = "";
        String language = "";
        String copyright = "";
        String author = "";
        String pubdate = "";
        String guid = "";

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

        InputStream in = read(url);

        XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            if (event.isStartElement()) {
                String localPart = event.asStartElement().getName().getLocalPart();
                switch (localPart) {
                    case ITEM:
                        if (isFeedHeader) {
                            isFeedHeader = false;
                            feed = new Feed(title, link, description);
                        }
                        event = eventReader.nextEvent();
                        break;
                    case TITLE:
                        title = getCharactedData(event, eventReader);
                        break;
                    case DESCRIPTION:
                        description = getCharactedData(event, eventReader);
                        break;
                    case LINK:
                        link = getCharactedData(event, eventReader);
                        break;
                }
            } else if (event.isEndElement()) {
                if (event.asEndElement().getName().getLocalPart() == ITEM) {
                    FeedMessage message = new FeedMessage(title, link, description);
                    feed.getFeedMessages().add(message);
                    event = eventReader.nextEvent();
                    continue;
                }
            }
        }
        return feed;
    }

    private static String getCharactedData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }

    private static InputStream read(URL url) throws IOException {
        return url.openStream();
    }
}
