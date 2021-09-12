package com.supremecorp.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.supremecorp.springsecurity.ApplicationUserRole.ADMIN;
import static com.supremecorp.springsecurity.ApplicationUserRole.STUDENT;

/**
 * Created by suprememajor on the 9/12/21
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails jamesMeyersUser = User.builder()
                .username("James")
                .password(passwordEncoder.encode("complicate"))
                .roles(STUDENT.name()) // ROLE_STUDENT
                .build();

        UserDetails majorUser = User.builder()
                .username("Major")
                .password(passwordEncoder.encode("complicate"))
                .roles(ADMIN.name()) // ROLE_STUDENT
                .build();
        return new InMemoryUserDetailsManager(
                jamesMeyersUser,
                majorUser
        );
    }
}
