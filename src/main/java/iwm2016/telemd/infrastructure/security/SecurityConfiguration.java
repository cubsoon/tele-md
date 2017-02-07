package iwm2016.telemd.infrastructure.security;

import com.auth0.spring.security.api.Auth0SecurityConfig;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Created by jakubk on 02.11.16.
 */
@Configuration
@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends Auth0SecurityConfig {

    /**
     * Provides Auth0 API access
     */
    @Bean
    public Auth0Client auth0Client() {
        return new Auth0Client(clientId, issuer);
    }

    /**
     *  Our API Configuration - for Profile CRUD operations
     *
     *  Here we choose not to bother using the `auth0.securedRoute` property configuration
     *  and instead ensure any unlisted endpoint in our config is secured by default
     */
    @Override
    protected void authorizeRequests(final HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/**").authenticated()
            .antMatchers("/**").permitAll();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/api/attachment/get/*");
    }

    /*
         * Only required for sample purposes..
         */
    String getAuthorityStrategy() {
        return super.authorityStrategy;
    }
}
