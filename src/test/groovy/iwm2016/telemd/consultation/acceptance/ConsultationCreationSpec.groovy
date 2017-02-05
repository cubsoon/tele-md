package iwm2016.telemd.consultation.acceptance

import base.IntegrationSpec
import base.MvcIntegrationSpec
import iwm2016.telemd.consultation.ConsultationDtoBuilder
import iwm2016.telemd.consultation.domain.ConsultationFacade
import org.junit.Ignore
import org.springframework.beans.factory.annotation.Autowired

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

/**
 * Created by jakubk on 05.11.16.
 */
@Ignore
class ConsultationCreationSpec extends IntegrationSpec {

    @Autowired
    private ConsultationFacade consultationFacade

    def "user should be able to create consultation entry"() {
        given:
            def dto = ConsultationDtoBuilder.createConsultationCreationDto("title", "description", "PUBLIC")
        when:
            def consultation = consultationFacade.createConsultation(dto)
        then:
            consultation.id != null
            consultation.title == "title"
            consultation.version == 0
            consultationFacade.getLatestConsultations().size() == 1
    }


}