package pirate.nojpg.rss.vo;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement(name = "rss")
public class FeedVO {

    @XmlElement(name = "channel")
    private ChannelVO channel;
}
