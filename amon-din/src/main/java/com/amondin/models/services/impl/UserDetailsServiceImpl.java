package com.amondin.models.services.impl;

import com.amondin.models.entities.User;
import com.amondin.models.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.debug("loadUserByUsername start");
        User user = userRepository.finUserByUsername(username);
        if (user != null) {
            return user;
        }
        LOGGER.debug("User {} not found.", username);
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
}
