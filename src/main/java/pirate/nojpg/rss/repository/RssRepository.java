package pirate.nojpg.rss.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pirate.nojpg.rss.dto.Domain;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository("RssRepository")
@Transactional
public class RssRepository {

    @Autowired
    private ListableBeanFactory beanFactory;
    private Repositories repositories;
    

    @PostConstruct
    public void setRepositories() {
        repositories = new Repositories(beanFactory);
    }

    public JpaRepository getRepository(Class clazz) {
        return Optional.ofNullable((JpaRepository) repositories.getRepositoryFor(clazz))
                .orElseThrow(() -> new RuntimeException("Can't get repository"));
    }

    public void save(Domain domain) {
        try {
            this.getRepository(domain.getClass()).save(domain);
        } catch (Exception ex) {
            log.debug("");
        }

    }

    @SuppressWarnings("unchecked")
    public void delete(Domain domain) {
        try {
            this.getRepository(domain.getClass()).delete(domain);
        } catch (Exception ex) {
            log.debug("");
        }
    }

    //    TODO change to Optional and Streams
    @SuppressWarnings("unchecked")
    public List findAll(Class clazz) {
        try {
            return this.getRepository(clazz).findAll();
        } catch (Exception ex) {
            log.debug("Fail");
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public Object findOne(Class clazz, Domain domain) {
        try {
            return this.getRepository(clazz).findOne(domain);
        } catch (Exception ex) {
            log.debug("");
            return new Object();
        }
    }
}
