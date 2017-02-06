package iwm2016.telemd.infrastructure.security;

import com.auth0.spring.security.api.Auth0JWTToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by jakm on 06.02.2017.
 */
public class Auth0UserDetailService implements UserDetailsService {

    private final Auth0Client auth0Client;

    public Auth0UserDetailService(Auth0Client auth0Client) {
        this.auth0Client = auth0Client;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return auth0Client.getUser((Auth0JWTToken) SecurityContextHolder.getContext().getAuthentication());
    }
}
