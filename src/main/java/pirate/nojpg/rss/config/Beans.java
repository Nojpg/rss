package pirate.nojpg.rss.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import pirate.nojpg.rss.vo.RssRootVo;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Beans {


    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(RssRootVo.class);
        marshaller.setMarshallerProperties(marshallerProperties());
        return marshaller;
    }

    @Bean
    public Map<String, Boolean> marshallerProperties() {
        Map<String, Boolean> props = new HashMap<>();
        props.put("jaxb.formatted.output", true);
        props.put("jaxb.fragment", true);
        return props;
    }
}
