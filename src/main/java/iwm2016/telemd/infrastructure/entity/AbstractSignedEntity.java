package iwm2016.telemd.infrastructure.entity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

/**
 * Created by jakubk on 07.11.16.
 */
@MappedSuperclass
public abstract class AbstractSignedEntity extends AbstractBaseEntity {

    @Column(name = "CREATED_BY")
    private String createdBy = getUsernameFromSecurityContext();

    @Column(name = "CREATED_ON", nullable = false)
    private Instant createdOn = Instant.now();

    protected String getCreatedBy() {
        return createdBy;
    }

    protected Instant getCreatedOn() {
        return createdOn;
    }

    private static String getUsernameFromSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated())  {
            return authentication.getName();
        }
        return null;
    }
}
