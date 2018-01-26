package pirate.nojpg.rss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import pirate.nojpg.rss.repository.RssRepository;

@Service
public class RssService {

    @Autowired
    private Jaxb2Marshaller marshaller;
    @Autowired
    private RssRepository repository;

    public void voToDto(String uri) {
//        RssRootVo root = (RssRootVo) marshaller.unmarshal(new StreamSource(uri));
//        Feed feed = new Feed();
//        feed.setDescription(root.getChannel());
//        feed.setLink();
//        feed.setTitle();
    }
}
