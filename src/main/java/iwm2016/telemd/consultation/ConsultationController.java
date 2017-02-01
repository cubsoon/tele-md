package iwm2016.telemd.consultation;

import iwm2016.telemd.consultation.domain.ConsultationFacade;
import iwm2016.telemd.consultation.dto.ConsultationCreationDto;
import iwm2016.telemd.consultation.dto.ConsultationListItemDto;
import org.springframework.beans.factory.annotation.Autowired;
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
}
