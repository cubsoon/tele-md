package iwm2016.telemd.attachment.domain;

import iwm2016.telemd.attachment.dto.AttachmentReferenceDto;
import iwm2016.telemd.infrastructure.entity.SignatureProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by jakubk on 08.11.16.
 */
@Component
public class AttachmentFacade {

    private AttachmentRepository attachmentRepository;

    private SignatureProvider signatureProvider;

    @Autowired
    public AttachmentFacade(AttachmentRepository attachmentRepository, SignatureProvider signatureProvider) {
        this.attachmentRepository = attachmentRepository;
        this.signatureProvider = signatureProvider;
    }

    public AttachmentReferenceDto uploadImageAttachment(InputStream stream) {

        Attachment attachment = Attachment.createFromStream(
                AttachmentType.IMAGE,
                signatureProvider.getCurrentUserSignature(),
                stream
        );

        attachmentRepository.saveAndFlush(attachment);
        return attachment.toReferenceDto();
    }

    public byte[] getBytes(String attachmentId) {
        Attachment attachment = attachmentRepository.getOne(attachmentId);
        return attachment.getBytes();
    }

}
