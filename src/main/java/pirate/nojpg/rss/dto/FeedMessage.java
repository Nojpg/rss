package pirate.nojpg.rss.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Table(name = "")
@Getter
@Setter
@NoArgsConstructor
public class FeedMessage extends Domain{

    @Column(name = "")
    private String title;
    @Column(name = "")
    private String link;
    @Column(name = "")
    private String description;

    public FeedMessage(String title, String link, String description) {
        this.title = title;
        this.link = link;
        this.description = description;
    }
}
