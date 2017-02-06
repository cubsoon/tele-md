package iwm2016.telemd.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by jakubk on 02.11.16.
 */
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    @Id
    private String id;

    @Column(nullable = false)
    private String username;

    public UserDto toDto() {
        UserDto dto = new UserDto();
        dto.id = id;
        dto.username = username;
        return dto;
    }

}
