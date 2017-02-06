package iwm2016.telemd.infrastructure.entity;

import iwm2016.telemd.infrastructure.datetime.DateProvider;
import iwm2016.telemd.infrastructure.entity.dto.SignatureDto;
import iwm2016.telemd.infrastructure.security.Auth0Client;
import iwm2016.telemd.users.User;
import iwm2016.telemd.users.UserProvider;
import lombok.Getter;

import javax.persistence.*;
import java.time.Instant;

/**
 * Created by jakubk on 07.11.16.
 */
@Embeddable
@Getter
public class Signature {

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "TIMESTAMP", nullable = false)
    private Instant timestamp;

    private Signature() {
        // this constructor is intentionally left blank
    }

    public SignatureDto toDto() {
        SignatureDto dto = new SignatureDto();
        dto.user = user != null ? user.toDto() : null;
        dto.timestamp = timestamp;
        return dto;
    }

    public static Signature createSignature(UserProvider userProvider, DateProvider dateProvider) {
        Signature signature = new Signature();
        signature.user = userProvider.getLoggedUser().orElse(null);
        signature.timestamp = dateProvider.now();
        return signature;
    }

    public static Signature createSignature(User user, Instant instant) {
        Signature signature = new Signature();
        signature.user = user;
        signature.timestamp = instant;
        return signature;
    }
}
