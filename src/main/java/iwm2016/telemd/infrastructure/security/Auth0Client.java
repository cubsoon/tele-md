package iwm2016.telemd.infrastructure.security;

import com.auth0.Auth0;
import com.auth0.authentication.AuthenticationAPIClient;
import com.auth0.authentication.result.UserProfile;
import com.auth0.request.Request;
import com.auth0.spring.security.api.Auth0JWTToken;
import org.springframework.stereotype.Component;

/**
 * Created by jakm on 01.02.2017.
 */
@Component
public class Auth0Client {

    private final String clientId;

    private final String domain;

    private final Auth0 auth0;

    private final AuthenticationAPIClient client;

    Auth0Client(String clientId, String domain) {
        this.clientId = clientId;
        this.domain = domain;
        this.auth0 = new Auth0(clientId, domain);
        this.client = this.auth0.newAuthenticationAPIClient();
    }

    public String getUsername(Auth0JWTToken token) {
        final Request<UserProfile> request = client.tokenInfo(token.getJwt());
        final UserProfile profile = request.execute();
        return profile.getEmail();
    }

}
