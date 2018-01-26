package pirate.nojpg.rss;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pirate.nojpg.rss.dto.Feed;
import pirate.nojpg.rss.dto.FeedMessage;
import pirate.nojpg.rss.repository.RssRepository;
import pirate.nojpg.rss.vo.ItemVo;
import pirate.nojpg.rss.vo.RssRootVo;

import javax.xml.transform.stream.StreamSource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RssApplicationTests {
    @Autowired
    private Jaxb2Marshaller marshaller;
    @Autowired
    private RssRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
    public void marshallerTest() {
        RssRootVo root = (RssRootVo) marshaller.unmarshal(new StreamSource("http://alogvinov.com/feed/"));
        Assert.assertNotNull(root);
    }

    @Test
    @Transactional
    public void transformerTest() {
        RssRootVo root = (RssRootVo) marshaller.unmarshal(new StreamSource("http://alogvinov.com/feed/"));
        Feed feed = new Feed();
        feed.setDescription(root.getChannel().getDescription());
        feed.setLink(root.getChannel().getLink());
        feed.setTitle(root.getChannel().getTitle());
        feed.setFeedMessages(transformItems(root.getChannel().getItems(), feed));
        repository.save(feed);
        List<Feed> feeds = (List<Feed>) repository.findAll(Feed.class);
        Assert.assertEquals(feeds.size(), 1);
    }

    private Set<FeedMessage> transformItems(Set<ItemVo> items, Feed feed) {
        return items.stream()
                .map(itemVo -> {
                    FeedMessage feedMessage = new FeedMessage();
                    feedMessage.setComment(itemVo.getComments());
                    feedMessage.setDescription(itemVo.getDescription());
                    feedMessage.setLink(itemVo.getLink());
                    feedMessage.setTitle(itemVo.getTitle());
                    feedMessage.addFeed(feed);
                    return feedMessage;
                }).collect(Collectors.toSet());
    }


}
