package iwm2016.telemd.attachment.domain;

import com.google.common.io.ByteStreams;
import iwm2016.telemd.attachment.dto.AttachmentReferenceDto;
import iwm2016.telemd.infrastructure.entity.AbstractBaseEntity;
import iwm2016.telemd.infrastructure.entity.Signature;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author kaminsj7
 */
@Entity
class Attachment extends AbstractBaseEntity {

    @Enumerated(EnumType.STRING)
    private AttachmentType type;

    @Embedded
    private Signature uploadSignature;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    byte[] bytes;

    @Override
    protected Class<?> getEntityClass() {
        return Attachment.class;
    }

    public static Attachment createFromStream(AttachmentType type, Signature signature, InputStream stream) {
        try {

            Attachment attachment = new Attachment();
            attachment.type = type;
            attachment.uploadSignature = signature;
            attachment.bytes = ByteStreams.toByteArray(stream);
            return attachment;

        } catch (IOException exception) {
            throw new IllegalArgumentException("Can't read from provided stream.", exception);
        }
    }

    public AttachmentReferenceDto toReferenceDto() {
        AttachmentReferenceDto dto = new AttachmentReferenceDto();
        dto.id = this.getId();
        dto.version = this.getVersion();
        dto.type = this.type.name();
        dto.uploaded = uploadSignature.toDto();
        return dto;
    }

    public byte[] getBytes() {
        return bytes;
    }
}
