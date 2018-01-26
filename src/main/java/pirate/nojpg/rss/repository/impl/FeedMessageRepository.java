package pirate.nojpg.rss.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import pirate.nojpg.rss.dto.FeedMessage;

public interface FeedMessageRepository extends JpaRepository<FeedMessage, Long> {
}
