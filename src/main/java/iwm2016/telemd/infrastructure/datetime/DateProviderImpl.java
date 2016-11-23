package iwm2016.telemd.infrastructure.datetime;

import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author kaminsj7
 */
@Component
class DateProviderImpl implements DateProvider {

    @Override
    public Instant now() {
        return Instant.now();
    }
}
