package pirate.nojpg.rss.dto;

import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@ToString
@Access(AccessType.FIELD)
public abstract class Domain extends AbstractPersistable<Long> {
}
