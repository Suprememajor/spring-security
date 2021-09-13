package com.supremecorp.springsecurity.auth;

import com.google.common.collect.Lists;
import com.supremecorp.springsecurity.ApplicationUserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.supremecorp.springsecurity.ApplicationUserRole.*;

/**
 * Created by suprememajor on the 9/13/21
 */
@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {

        return Lists.newArrayList(
            new ApplicationUser(
                    "James",
                    passwordEncoder.encode("complicate"),
                    STUDENT.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true),
            new ApplicationUser(
                "Major",
                    passwordEncoder.encode("complicate"),
                    ADMIN.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true),
            new ApplicationUser(
                    "Prince",
                    passwordEncoder.encode("complicate"),
                    ADMINTRAINEE.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true)
        );
    }
}
