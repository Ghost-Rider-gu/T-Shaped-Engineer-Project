/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.account.api;

import com.online.shop.account.domain.Order;
import com.online.shop.account.domain.User;
import com.online.shop.account.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    private final AccountServiceImpl accountService;

    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/")
    public void createAccount(@Valid @RequestBody User user) {
        accountService.createAccount(user);
    }

    @PreAuthorize("#oauth2.hasScope('backend')")
    @GetMapping("/orders")
    public List<Order> getOrders(Principal principal) {
        return accountService.getOrders(principal.getName());
    }
}
