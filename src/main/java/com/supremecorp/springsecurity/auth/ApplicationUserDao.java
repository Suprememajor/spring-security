package com.supremecorp.springsecurity.auth;

import java.util.Optional;

/**
 * Created by suprememajor on the 9/13/21
 */
public interface ApplicationUserDao {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
