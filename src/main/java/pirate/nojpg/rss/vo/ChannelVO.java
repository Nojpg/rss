package pirate.nojpg.rss.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ChannelVO {
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "link")
    private String link;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "item")
    private Set<ItemVo> items;
    @XmlElement(name = "image")
    private ImageVO image;
}
