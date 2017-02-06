package iwm2016.telemd.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by jakubk on 02.11.16.
 */
@Builder
@AllArgsConstructor
public class User implements UserDetails {

    private String id;

    private String username;

    public UserDto toDto() {
        UserDto dto = new UserDto();
        dto.id = id;
        dto.username = username;
        return dto;
    }

    public String getUsername() {
        return id;
    }

    public String getDisplayedUsername() {
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

    @Override
    public String getPassword() {
        return null;
    }

}
