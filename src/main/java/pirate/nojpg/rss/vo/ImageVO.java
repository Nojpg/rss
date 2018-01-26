package pirate.nojpg.rss.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageVO {
    @XmlElement(name = "url")
    private String url;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "link")
    private String link;
    @XmlElement(name = "width")
    private int width;
    @XmlElement(name = "height")
    private int height;
}
