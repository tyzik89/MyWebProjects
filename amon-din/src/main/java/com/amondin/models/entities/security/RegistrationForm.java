package com.amondin.models.entities.security;

import com.amondin.models.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationForm {

    private String username;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username,
                passwordEncoder.encode(password));
    }
}
