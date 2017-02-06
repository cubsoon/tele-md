package iwm2016.telemd.consultation.domain;

import iwm2016.telemd.consultation.dto.PostDto;
import iwm2016.telemd.infrastructure.entity.AbstractBaseEntity;
import iwm2016.telemd.infrastructure.entity.Signature;
import lombok.Getter;

import javax.persistence.*;

/**
 * Created by jakm on 05.02.2017.
 */
@Entity
@Getter
public class Post extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONSULTATION_ID")
    private Consultation consultation;

    private String content;

    @Embedded
    private Signature added;

    @Embedded
    private ImageReference image;

    @Override
    protected Class<?> getEntityClass() {
        return Post.class;
    }

    public PostDto toDto() {
        PostDto dto = new PostDto();
        dto.id = getId();
        dto.version = getVersion();
        dto.added = added.toDto();
        dto.content = content;
        dto.image = image != null ? image.toDto() : null;
        return dto;
    }

    public static Post fromDto(PostDto dto, Consultation consultation, Signature signature) {
        Post entity = new Post();
        entity.content = dto.content.trim();
        entity.added = signature;
        entity.image = ImageReference.fromDto(dto.image);
        entity.consultation = consultation;
        return entity;
    }
}
