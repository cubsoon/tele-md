package iwm2016.telemd.users;

import org.springframework.data.repository.Repository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by jakubk on 02.11.16.
 */
public interface UserRepository extends Repository<User, String>, UserDetailsService {

    User findOneByUsername(String username);

    User save(User user);

    @Override
    default UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user with username " + username);
        }
        return user;
    }
}
