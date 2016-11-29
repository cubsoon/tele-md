package iwm2016.telemd.attachment.domain;

import iwm2016.telemd.attachment.dto.AttachmentReferenceDto;
import iwm2016.telemd.infrastructure.entity.SignatureProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;


/**
 * Created by jakubk on 08.11.16.
 */
@Component
public class AttachmentFacade {

    private static final Logger LOG = LoggerFactory.getLogger(AttachmentFacade.class);

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
        LOG.info("Image with id [{}] uploaded", attachment.toReferenceDto().id);
        return attachment.toReferenceDto();
    }

    public byte[] getBytes(String attachmentId) {
        Attachment attachment = attachmentRepository.getOne(attachmentId);
        return attachment.getBytes();
    }

}
