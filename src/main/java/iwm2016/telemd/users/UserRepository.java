package iwm2016.telemd.users;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jakm on 06.02.2017.
 */
public interface UserRepository extends JpaRepository<User, String> {
}
