package iwm2016.telemd.users;

import org.springframework.data.repository.Repository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

/**
 * Created by jakubk on 02.11.16.
 */
interface UserRepository extends Repository<User, String>, UserDetailsService {

    Optional<User> findOneByUsername(String username);

    User save(User user);

    @Override
    default UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = findOneByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("No user with username " + username + ".");
        }
        return user.get();
    }
}
