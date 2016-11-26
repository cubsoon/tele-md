package iwm2016.telemd.consultation.acceptance

import base.IntegrationSpec
import com.google.common.io.ByteStreams
import iwm2016.telemd.attachment.domain.AttachmentFacade
import iwm2016.telemd.attachment.dto.AttachmentReferenceDto
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author kaminsj7
 */
class AttachmentUploadSpec extends IntegrationSpec {

    @Autowired
    private AttachmentFacade attachmentFacade;

    def "user should be able to upload image"() {
        given:
            def image = givenPersistedImage();
        when:
            def imageBytes = attachmentFacade.getBytes(image.id)
        then:
            Arrays.equals(imageBytes, expectedPersistedImageBytes())
    }

    private AttachmentReferenceDto givenPersistedImage() {
        InputStream stream = this.class.getResourceAsStream("/test_image.png")
        AttachmentReferenceDto reference = attachmentFacade.uploadImageAttachment(stream)
        stream.close()
        return reference
    }

    private byte[] expectedPersistedImageBytes() {
        InputStream stream = this.class.getResourceAsStream("/test_image.png")
        byte[] bytes = ByteStreams.toByteArray(stream)
        stream.close()
        return bytes;
    }

}
