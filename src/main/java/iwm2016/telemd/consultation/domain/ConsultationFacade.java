package iwm2016.telemd.consultation.domain;

import iwm2016.telemd.consultation.dto.ConsultationCreationDto;
import iwm2016.telemd.consultation.dto.ConsultationListItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jakubk on 05.11.16.
 */
@Component
public class ConsultationFacade {

    private ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationFacade(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public List<ConsultationListItemDto> getLatestConsultations() {
        Pageable pageable = new PageRequest(0, 10, ConsultationRepository.CREATED_ON_DESC_ORDER);
        return consultationRepository.findAllByPrivacy(ConsultationPrivacy.PUBLIC, pageable).stream()
                .map(Consultation::toListItemDto)
                .collect(Collectors.toList());
    }

    public ConsultationListItemDto createConsultation(ConsultationCreationDto dto) {
        Consultation consultation = consultationRepository.save(Consultation.fromCreationDto(dto));
        consultationRepository.saveAndFlush(consultation);
        return consultation.toListItemDto();

        ImageIO.
    }

}
