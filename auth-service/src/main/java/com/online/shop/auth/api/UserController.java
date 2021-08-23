/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.auth.api;

import com.online.shop.auth.domain.user.User;
import com.online.shop.auth.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth")
    public void createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/current")
    public Principal getCurrentUser(Principal principal) {
        return principal;
    }
}
