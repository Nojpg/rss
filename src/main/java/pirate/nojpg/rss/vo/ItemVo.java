package pirate.nojpg.rss.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemVo {

    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "link")
    private String link;
    @XmlElement(name = "comments")
    private String comments;
    @XmlElement(name = "category")
    private Set<String> categories;
    @XmlElement(name = "description")
    private String description;

}
