package iwm2016.telemd.users;

import iwm2016.telemd.infrastructure.entity.AbstractBaseEntity;
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
public class User extends AbstractBaseEntity implements UserDetails{

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String password;

    private User() {
        // this constructor is intentionally left blank
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDto toDto() {
        UserDto dto = new UserDto();
        dto.id = this.getId();
        dto.username = this.getDisplayedName();
        return dto;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayedName() {
        return username;
    }

    @Override
    protected Class<?> getEntityClass() {
        return User.class;
    }
}
