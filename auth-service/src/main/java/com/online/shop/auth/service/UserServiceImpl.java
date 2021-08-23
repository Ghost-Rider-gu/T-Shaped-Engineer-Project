/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.auth.service;

import com.online.shop.auth.domain.user.User;
import com.online.shop.auth.exception.UserAlreadyExistsException;
import com.online.shop.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
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
            throw new UserAlreadyExistsException(String.format("This user: %s already exists", user.getUsername()));
        });

        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);

        userRepository.save(user);
    }
}
