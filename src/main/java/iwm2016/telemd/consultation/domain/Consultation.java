package iwm2016.telemd.consultation.domain;

import iwm2016.telemd.consultation.dto.ConsultationCreationDto;
import iwm2016.telemd.consultation.dto.ConsultationListItemDto;
import iwm2016.telemd.infrastructure.entity.AbstractBaseEntity;
import iwm2016.telemd.infrastructure.entity.Signature;
import iwm2016.telemd.users.User;
import iwm2016.telemd.users.UserProvider;

import javax.persistence.*;
import java.time.Instant;

/**
 * Created by jakubk on 05.11.16.
 */
@Entity
@Table(name = "CONSULTATIONS")
class Consultation extends AbstractBaseEntity {

    private String title;

    private String description;

    @Embedded
    private Signature creationSignature;

    @Column(name = "PRIVACY")
    @Enumerated(EnumType.STRING)
    private ConsultationPrivacy privacy;

    public ConsultationListItemDto toListItemDto() {
        ConsultationListItemDto dto = new ConsultationListItemDto();
        dto.id = this.getId();
        dto.version = this.getVersion();
        dto.title = this.title;
        dto.created = creationSignature.toDto();
        return dto;
    }

    public static Consultation fromCreationDto(ConsultationCreationDto dto, Signature signature) {
        Consultation consultation = new Consultation();
        consultation.title = dto.title;
        consultation.description = dto.description;
        consultation.privacy = ConsultationPrivacy.valueOf(dto.privacy);
        consultation.creationSignature = signature;
        return consultation;
    }

    @Override
    protected Class<?> getEntityClass() {
        return Consultation.class;
    }
}
