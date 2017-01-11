package iwm2016.telemd.consultation.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import iwm2016.telemd.consultation.dto.ConsultationActionDto;
import iwm2016.telemd.consultation.exception.ActionException;
import iwm2016.telemd.infrastructure.entity.AbstractBaseEntity;
import iwm2016.telemd.infrastructure.entity.Signature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kaminsj7
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONSULTATION_ACTIONS")
public class ConsultationAction extends AbstractBaseEntity {

    @Embedded
    private Signature signature;

    private String consultationId;

    @Column(length = 512)
    private String parameters;

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    public static ConsultationAction fromDto(String consultationId, Signature signature, ConsultationActionDto dto) {
        try {
            final String parameters = new ObjectMapper().writeValueAsString(dto.parameters);
            final ActionType actionType = ActionType.valueOf(dto.actionType);
            return ConsultationAction.builder()
                    .consultationId(consultationId)
                    .signature(signature)
                    .actionType(actionType)
                    .parameters(parameters)
                    .build();
        } catch (Exception e) {
            throw new ActionException(e);
        }
    }

    public ConsultationActionDto toDto() {
        ConsultationActionDto dto = new ConsultationActionDto();
        dto.id = getId();
        dto.actionType = getActionType().name();
        dto.signature = signature.toDto();
        dto.parameters = getParameterMap();
        return dto;
    }

    @Override
    protected Class<?> getEntityClass() {
        return ConsultationAction.class;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getParameterMap() {
        try {
            return new ObjectMapper().readValue(this.getParameters(), HashMap.class);
        } catch (Exception e) {
            throw new ActionException(e);
        }
    }

}
