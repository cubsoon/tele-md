package iwm2016.telemd.users;

import com.auth0.spring.security.api.Auth0JWTToken;
import iwm2016.telemd.infrastructure.security.Auth0Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author kaminsj7
 */
@Component
class Auth0TokenUserProvider implements UserProvider {

    @Autowired
    private Auth0Client auth0Client;

    @Override
    public Optional<User> getLoggedUser() {
        return Optional.ofNullable(getUserFromToken());
    }

    private User getUserFromToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return auth0Client.getUser((Auth0JWTToken) authentication);
    }

}
