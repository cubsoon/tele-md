package iwm2016.telemd.consultation.dto;

import iwm2016.telemd.infrastructure.entity.dto.SignatureDto;

import java.util.Map;

/**
 * @author kaminsj7
 */
public class ConsultationActionDto {

    public String id;
    public SignatureDto signature;
    public String actionType;
    public Map<String, Object> parameters;

}
