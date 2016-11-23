package iwm2016.telemd.infrastructure.datetime;

import java.time.Instant;

/**
 * @author kaminsj7
 */
public interface DateProvider {

    Instant now();

}
