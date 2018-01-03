package pirate.nojpg.rss;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pirate.nojpg.rss.dto.Feed;
import pirate.nojpg.rss.service.RssService;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RssApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void testTest() throws MalformedURLException {
		Feed feed = RssService.test(new URL("http://alogvinov.com/feed/"));
		System.out.println(feed);
		feed.getFeedMessages().forEach(System.out::println);
	}
}
