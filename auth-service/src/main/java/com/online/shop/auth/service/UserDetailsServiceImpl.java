/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.auth.service;

import com.online.shop.auth.domain.user.UserDetailsImpl;
import com.online.shop.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot find the user: " + username));
    }
}
