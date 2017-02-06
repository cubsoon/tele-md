package iwm2016.telemd.users;

import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author kaminsj7
 */
@Component
public interface UserProvider {

    Optional<User> getLoggedUser();

}
