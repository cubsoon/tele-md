package iwm2016.telemd.users;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author kaminsj7
 */
@Component
public interface UserProvider extends UserDetailsService {

    Optional<User> getLoggedUser();

}
