package iwm2016.telemd.consultation.domain;

import iwm2016.telemd.consultation.dto.ImageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * Created by jakm on 05.02.2017.
 */
@Embeddable
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageReference {

    private String title;

    private String attachmentId;

    public ImageDto toDto() {
        ImageDto dto = new ImageDto();
        dto.attachmentId = attachmentId;
        dto.title = title;
        return dto;
    }

    public static ImageReference fromDto(ImageDto dto) {
        if (dto == null || dto.attachmentId == null) {
            return null;
        }

        return new ImageReference(dto.title, dto.attachmentId);
    }
}
