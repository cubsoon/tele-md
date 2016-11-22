package iwm2016.telemd.infrastructure.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Created by jakubk on 02.11.16.
 */
@MappedSuperclass
public abstract class AbstractBaseEntity {

    @Id
    private String id = IdGenerator.generateId();

    @Version
    private Long version;

    protected String getId() {
        return this.id;
    }

    protected Long getVersion() {
        return this.version;
    }

    protected abstract Class<?> getEntityClass();

    @Override
    public boolean equals(Object other) {

        if (this == other) {
            return true;
        }

        final boolean objectClassSameOrProxy = this.getEntityClass().isAssignableFrom(other.getClass());
        if (!(objectClassSameOrProxy)) {
            return false;
        }

        final AbstractBaseEntity otherEntity = (AbstractBaseEntity) other;
        return this.getId().equals(otherEntity.getId());

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
