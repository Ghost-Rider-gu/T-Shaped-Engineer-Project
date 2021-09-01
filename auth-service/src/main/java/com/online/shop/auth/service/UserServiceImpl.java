/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.auth.service;

import com.online.shop.auth.domain.user.User;
import com.online.shop.auth.exception.UserAlreadyExistsException;
import com.online.shop.auth.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(User user) {
        Optional<User> existingUser = userRepository.findUserByUsername(user.getUsername());
        existingUser.ifPresent(currentUser -> {
            log.error("Couldn't create a new user: cause user already exists");
            throw new UserAlreadyExistsException(String.format("This user: %s already exists", user.getUsername()));
        });

        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);

        userRepository.save(user);
        log.info("User '{}' has been created.", user.getUsername());
    }

    @Override
    public List<User> findUsersByAuthority(String authority) {
        Optional<List<User>> users = userRepository.findUsersByAuthority(authority);
        if (users.isPresent()) {
            log.info("A list of users has been returned");
            return users.get();
        } else {
            log.error("Couldn't get users by '{}' authority", authority);
            return Collections.emptyList();
        }
    }
}
