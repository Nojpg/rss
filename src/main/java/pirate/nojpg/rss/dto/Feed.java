package pirate.nojpg.rss.dto;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "")
@ToString
@AllArgsConstructor
public class Feed extends Domain{
    @Column(name = "")
    private String title;
//    @Column(name = "")
//    private Date date;
    @Column(name = "")
    private String description;
    @Column(name = "")
    private String link;
    @Transient
    private List<FeedMessage> feedMessages = new ArrayList<>();

    public Feed(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }
}
