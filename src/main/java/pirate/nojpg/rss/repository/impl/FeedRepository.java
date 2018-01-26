package pirate.nojpg.rss.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import pirate.nojpg.rss.dto.Feed;


public interface FeedRepository extends JpaRepository<Feed, Long> {
}
