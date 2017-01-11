package iwm2016.telemd.consultation;

import iwm2016.telemd.consultation.domain.ConsultationFacade;
import iwm2016.telemd.consultation.dto.ConsultationActionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * @author kaminsj7
 */
@RestController
public class ConsultationActionController {

    @Autowired
    private ConsultationFacade consultationFacade;

    @RequestMapping(path = "/consultation/{consultationId}/newActions", method = POST, produces = APPLICATION_JSON_VALUE)
    public List<ConsultationActionDto> getNewActions(@PathVariable String consultationId,
                                                     @RequestBody List<String> lastActionIds) {
        return consultationFacade.getNewActions(consultationId, lastActionIds);
    }

    @RequestMapping(path = "/consultation/{consultationId}/newActions", method = PUT, produces = APPLICATION_JSON_VALUE)
    public void getNewActions(@PathVariable String consultationId,
                                                     @RequestBody ConsultationActionDto actionDto) {
        consultationFacade.doAction(consultationId, actionDto);
    }
}
