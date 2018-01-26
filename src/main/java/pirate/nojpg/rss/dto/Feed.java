package pirate.nojpg.rss.dto;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Feed")
@ToString(exclude = "feedMessages")
@AllArgsConstructor
@Access(AccessType.FIELD)
public class Feed extends Domain{
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "link")
    private String link;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "feed", fetch = FetchType.LAZY)
    private Set<FeedMessage> feedMessages = new HashSet<>();
}
