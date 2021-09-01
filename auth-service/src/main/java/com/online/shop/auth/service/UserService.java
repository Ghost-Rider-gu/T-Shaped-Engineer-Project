/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.auth.service;

import com.online.shop.auth.domain.user.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    List<User> findUsersByAuthority(final String authority);
}
