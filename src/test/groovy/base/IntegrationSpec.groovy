package base

import iwm2016.telemd.TeleMdApplication
import iwm2016.telemd.infrastructure.profile.Profiles
import iwm2016.telemd.users.User
import iwm2016.telemd.users.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.RememberMeAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

/**
 * Created by jakubk on 05.11.16.
 */
@Rollback
@Transactional
@ContextConfiguration(classes = TeleMdApplication)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles(Profiles.TEST)
abstract class IntegrationSpec extends Specification {

    protected static final String USERNAME = "testuser"

    protected static final String PASSWORD = "testpass"

    @Autowired
    private AuthenticationManager authenticationManager

    @Autowired
    private UserRepository userRepository

    void setup() {
        loginUser()
    }

    private void loginUser() {
        User user = new User(USERNAME, PASSWORD)
        userRepository.save(user)

        UserDetails userDetails = userRepository.findOneByUsername(USERNAME)

        RememberMeAuthenticationToken token = new RememberMeAuthenticationToken("key", userDetails, null)
        token.setAuthenticated(true)

        SecurityContextHolder.getContext().setAuthentication(token)
    }
}
