package iwm2016.telemd.consultation.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * @author kaminsj7
 */
interface ConsultationActionRepository extends JpaRepository<ConsultationAction, String> {

    ConsultationAction findFirstByIdInAndConsultationIdOrderBySignatureTimestampAsc(
            List<String> lastIds,
            String consultationId
    );

    List<ConsultationAction> findBySignatureTimestampGreaterThanAndIdNotInAndConsultationIdEqualsOrderBySignatureTimestampAsc(
            Instant fromTimestamp,
            List<String> lastIds,
            String consultationId
    );
}
