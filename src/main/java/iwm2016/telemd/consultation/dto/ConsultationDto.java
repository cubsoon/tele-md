package iwm2016.telemd.consultation.dto;

import iwm2016.telemd.infrastructure.entity.dto.SignatureDto;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jakm on 05.02.2017.
 */
public class ConsultationDto {

    public String id;

    public Long version;

    public String title;

    public String description;

    public SignatureDto created;

    public List<PostDto> posts = new LinkedList<>();
}
