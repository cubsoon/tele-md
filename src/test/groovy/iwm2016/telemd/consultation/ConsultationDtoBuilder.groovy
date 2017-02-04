package iwm2016.telemd.consultation

import iwm2016.telemd.consultation.dto.ConsultationCreationDto
import spock.lang.Specification


/**
 * Created by jakubk on 07.11.16.
 */
class ConsultationDtoBuilder extends Specification {

    static ConsultationCreationDto createConsultationCreationDto(String title, String description, String privacy) {
        return new ConsultationCreationDto(description: description, title: title)
    }

}