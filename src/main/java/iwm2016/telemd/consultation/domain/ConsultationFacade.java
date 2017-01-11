package iwm2016.telemd.consultation.domain;

import iwm2016.telemd.consultation.dto.ConsultationActionDto;
import iwm2016.telemd.consultation.dto.ConsultationCreationDto;
import iwm2016.telemd.consultation.dto.ConsultationListItemDto;
import iwm2016.telemd.infrastructure.entity.Signature;
import iwm2016.telemd.infrastructure.entity.SignatureProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jakubk on 05.11.16.
 */
@Component
public class ConsultationFacade {

    private final ConsultationRepository consultationRepository;

    private final ConsultationActionRepository consultationActionRepository;

    private final SignatureProvider signatureProvider;

    @Autowired
    public ConsultationFacade(ConsultationRepository consultationRepository,
                              ConsultationActionRepository consultationActionRepository,
                              SignatureProvider signatureProvider) {
        this.consultationRepository = consultationRepository;
        this.consultationActionRepository = consultationActionRepository;
        this.signatureProvider = signatureProvider;
    }

    public List<ConsultationListItemDto> getLatestConsultations() {
        Pageable pageable = new PageRequest(0, 10, ConsultationRepository.CREATED_ON_DESC_ORDER);
        return consultationRepository.findAllByPrivacy(ConsultationPrivacy.PUBLIC, pageable).stream()
                .map(Consultation::toListItemDto)
                .collect(Collectors.toList());
    }

    public ConsultationListItemDto createConsultation(ConsultationCreationDto dto) {
        Signature signature = signatureProvider.getCurrentUserSignature();
        Consultation consultation = consultationRepository.save(
                Consultation.fromCreationDto(dto, signature));
        consultationRepository.saveAndFlush(consultation);
        return consultation.toListItemDto();
    }

    public List<ConsultationActionDto> getNewActions(String consultationId, List<String> lastActionIds) {
        // TODO: fix style
        ConsultationAction oldestRecentAction = consultationActionRepository
                .findFirstByIdInAndConsultationIdOrderBySignatureTimestampAsc(lastActionIds, consultationId);

        List<ConsultationAction> newActions = consultationActionRepository
                .findBySignatureTimestampGreaterThanAndIdNotInAndConsultationIdEqualsOrderBySignatureTimestampAsc(
                        oldestRecentAction.getSignature().getTimestamp(), lastActionIds, consultationId);

        return newActions.stream().map(ConsultationAction::toDto).collect(Collectors.toList());
    }

    public ConsultationActionDto doAction(String consultationId, ConsultationActionDto actionDto) {
        Signature signature = signatureProvider.getCurrentUserSignature();
        ConsultationAction consultationAction = ConsultationAction.fromDto(consultationId, signature, actionDto);
        consultationActionRepository.saveAndFlush(consultationAction);
        return consultationAction.toDto();
    }

}
