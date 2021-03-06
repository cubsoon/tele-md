package iwm2016.telemd.consultation.domain;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * Created by jakubk on 07.11.16.
 */
interface ConsultationRepository extends JpaRepository<Consultation, String> {

    Sort CREATED_ON_DESC_ORDER = new Sort(DESC, "creationSignature.timestamp");

}
