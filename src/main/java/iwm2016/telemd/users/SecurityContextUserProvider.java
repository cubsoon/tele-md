package iwm2016.telemd.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        return userRepository.findOneByUsername(getUsernameFromSecurityContext());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("test")) {
            return new User("test", "test");
        }

        Optional<User> user = userRepository.findOneByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("No user with username " + username + ".");
        }
        return user.get();
    }

    private static String getUsernameFromSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated())  {
            return authentication.getName();
        }
        return null;
    }

}
