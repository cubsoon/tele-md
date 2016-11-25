package iwm2016.telemd.consultation.domain;

import iwm2016.telemd.consultation.dto.ConsultationCreationDto;
import iwm2016.telemd.consultation.dto.ConsultationListItemDto;
import iwm2016.telemd.infrastructure.datetime.DateProvider;
import iwm2016.telemd.infrastructure.entity.Signature;
import iwm2016.telemd.users.User;
import iwm2016.telemd.users.UserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.io.File;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jakubk on 05.11.16.
 */
@Component
public class ConsultationFacade {

    private ConsultationRepository consultationRepository;

    private DateProvider dateProvider;

    private UserProvider userProvider;

    @Autowired
    public ConsultationFacade(ConsultationRepository consultationRepository,
                              DateProvider dateProvider,
                              UserProvider userProvider) {
        this.consultationRepository = consultationRepository;
        this.dateProvider = dateProvider;
        this.userProvider = userProvider;
    }

    public List<ConsultationListItemDto> getLatestConsultations() {
        Pageable pageable = new PageRequest(0, 10, ConsultationRepository.CREATED_ON_DESC_ORDER);
        return consultationRepository.findAllByPrivacy(ConsultationPrivacy.PUBLIC, pageable).stream()
                .map(Consultation::toListItemDto)
                .collect(Collectors.toList());
    }

    public ConsultationListItemDto createConsultation(ConsultationCreationDto dto) {
        Signature signature = Signature.createSignature(userProvider, dateProvider);
        Consultation consultation = consultationRepository.save(
                Consultation.fromCreationDto(dto, signature));
        consultationRepository.saveAndFlush(consultation);
        return consultation.toListItemDto();
    }

}
