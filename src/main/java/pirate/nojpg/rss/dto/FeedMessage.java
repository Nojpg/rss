package pirate.nojpg.rss.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString(exclude = "feed")
@Table(name = "FeedMessage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class FeedMessage extends Domain{
    @Column(name = "title")
    private String title;
    @Column(name = "link")
    private String link;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "comment")
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", referencedColumnName = "id")
    private Feed feed;
//    @ElementCollection
//    @Column()
//    private Set<String> categories;

    public void addFeed(Feed feed) {
        this.feed = feed;
        feed.getFeedMessages().add(this);
    }
}
