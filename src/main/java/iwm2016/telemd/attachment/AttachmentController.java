package iwm2016.telemd.attachment;

import iwm2016.telemd.attachment.domain.AttachmentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author kaminsj7
 */
@Controller
public class AttachmentController {

    private final AttachmentFacade attachmentFacade;

    @Autowired
    public AttachmentController(AttachmentFacade attachmentFacade) {
        this.attachmentFacade = attachmentFacade;
    }

    @PostMapping(path = "attachment/upload")
    public @ResponseBody void uploadAttachment(@RequestParam("file") MultipartFile file) throws IOException {
        attachmentFacade.uploadImageAttachment(file.getInputStream());
    }

    @GetMapping(path = "attachment/{attachmentId}")
    public ResponseEntity<Resource> serveAttachment(@PathVariable String attachmentId) {
        byte[] attachmentBytes = attachmentFacade.getBytes(attachmentId);
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(MediaType.IMAGE_JPEG_VALUE))
                .body(new ByteArrayResource(attachmentBytes));
    }
}
