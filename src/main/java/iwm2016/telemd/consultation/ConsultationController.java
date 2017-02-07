package iwm2016.telemd.consultation;

import iwm2016.telemd.consultation.domain.ConsultationFacade;
import iwm2016.telemd.consultation.dto.ConsultationCreationDto;
import iwm2016.telemd.consultation.dto.ConsultationDto;
import iwm2016.telemd.consultation.dto.ConsultationListItemDto;
import iwm2016.telemd.consultation.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created by jakm on 01.02.2017.
 */
@RestController
@RequestMapping("/api")
public class ConsultationController {

    @Autowired
    private ConsultationFacade consultationFacade;

    @RequestMapping(path = "/consultation", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<ConsultationListItemDto> getLatestConsultations() {
        return consultationFacade.getLatestConsultations();
    }

    @RequestMapping(path = "/consultation", method = PUT, produces = APPLICATION_JSON_VALUE)
    public void addConsultation(@RequestBody ConsultationCreationDto consultationCreationDto) {
        consultationFacade.createConsultation(consultationCreationDto);
    }

    @RequestMapping(path = "/consultation/{consultationId}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ConsultationDto getConsultation(@PathVariable String consultationId) {
        return consultationFacade.getConsultation(consultationId);
    }

    @RequestMapping(path = "/consultation/{consultationId}/post", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<PostDto> getPosts(@PathVariable String consultationId) {
        return consultationFacade.getPosts(consultationId);
    }

    @RequestMapping(path = "/consultation/{consultationId}/post", method = PUT, produces = APPLICATION_JSON_VALUE)
    public void addPost(@RequestBody PostDto dto, @PathVariable String consultationId) {
        consultationFacade.createPost(dto, consultationId);
    }
}
