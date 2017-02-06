package iwm2016.telemd.consultation.domain;

import iwm2016.telemd.consultation.dto.ConsultationCreationDto;
import iwm2016.telemd.consultation.dto.ConsultationDto;
import iwm2016.telemd.consultation.dto.ConsultationListItemDto;
import iwm2016.telemd.infrastructure.entity.AbstractBaseEntity;
import iwm2016.telemd.infrastructure.entity.Signature;
import lombok.Getter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static javax.persistence.CascadeType.ALL;

/**
 * Created by jakubk on 05.11.16.
 */
@Entity
@Getter
@Table(name = "CONSULTATIONS")
class Consultation extends AbstractBaseEntity {

    private String title;

    private String description;

    @Embedded
    private Signature creationSignature;

    @OneToMany(mappedBy = "consultation", cascade = { ALL })
    private Set<Post> posts = new HashSet<>();

    public ConsultationListItemDto toListItemDto() {
        ConsultationListItemDto dto = new ConsultationListItemDto();
        dto.id = this.getId();
        dto.version = this.getVersion();
        dto.title = this.title;
        dto.description = this.description;
        dto.created = creationSignature.toDto();
        return dto;
    }

    public ConsultationDto toDto() {
        ConsultationDto dto = new ConsultationDto();
        dto.id = this.getId();
        dto.version = this.getVersion();
        dto.title = this.title;
        dto.description = this.description;
        dto.created = creationSignature.toDto();
        dto.posts.addAll(getPosts().stream()
            .sorted(Comparator.comparing((Post post) -> post.getAdded().getTimestamp()))
            .map(Post::toDto)
            .collect(toList()));
        return dto;
    }

    public static Consultation fromCreationDto(ConsultationCreationDto dto, Signature signature) {
        Consultation consultation = new Consultation();
        consultation.title = dto.title;
        consultation.description = dto.description;
        consultation.creationSignature = signature;
        return consultation;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    @Override
    protected Class<?> getEntityClass() {
        return Consultation.class;
    }
}
