package iwm2016.telemd.users;

import com.auth0.spring.security.api.Auth0JWTToken;
import iwm2016.telemd.infrastructure.security.Auth0Client;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author kaminsj7
 */
@Component
class PersistedUserProvider implements UserProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Auth0Client auth0Client;

    @Override
    public Optional<User> getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            User user = userRepository.findOne(auth0Client.getUserId((Auth0JWTToken) authentication));
            if (user == null) {
                return Optional.of(createPersistedUser(authentication));
            } else {
                return Optional.of(user);
            }
        } else {
            return Optional.empty();
        }
    }

    private User createPersistedUser(Authentication authentication) {
        User user = auth0Client.getUser((Auth0JWTToken) authentication);
        return userRepository.saveAndFlush(user);
    }
}
