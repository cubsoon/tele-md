package iwm2016.telemd.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author kaminsj7
 */
@Component
class SecurityContextUserProvider implements UserProvider {

    private UserRepository userRepository;

    @Autowired
    public SecurityContextUserProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getLoggedUser() {
        String username = getUsernameFromSecurityContext();
        return userRepository.findOneByUsername(getUsernameFromSecurityContext());
    }

    private static String getUsernameFromSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated())  {
            return authentication.getName();
        }
        return null;
    }
}
