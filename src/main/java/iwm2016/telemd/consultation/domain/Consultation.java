package iwm2016.telemd.consultation.domain;

import iwm2016.telemd.consultation.dto.ConsultationCreationDto;
import iwm2016.telemd.consultation.dto.ConsultationListItemDto;
import iwm2016.telemd.infrastructure.entity.AbstractSignedEntity;

import javax.persistence.*;
import java.time.Instant;

/**
 * Created by jakubk on 05.11.16.
 */
@Entity
@Table(name = "CONSULTATIONS")
class Consultation extends AbstractSignedEntity {

    private String title;

    private String description;

    @Column(name = "PRIVACY")
    @Enumerated(EnumType.STRING)
    private ConsultationPrivacy privacy;

    public ConsultationListItemDto toListItemDto() {
        ConsultationListItemDto dto = new ConsultationListItemDto();
        dto.id = getId();
        dto.version = getVersion();
        dto.created = getCreatedOn().toEpochMilli();
        dto.createdBy = getCreatedBy();

        dto.title = title;
        return dto;
    }

    public static Consultation fromCreationDto(ConsultationCreationDto dto) {
        Consultation consultation = new Consultation();
        consultation.title = dto.title;
        consultation.description = dto.description;
        return consultation;
    }

    @Override
    protected Class<?> getEntityClass() {
        return Consultation.class;
    }
}
