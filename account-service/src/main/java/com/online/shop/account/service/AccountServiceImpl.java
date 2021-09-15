/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.account.service;

import com.online.shop.account.client.AuthServiceClient;
import com.online.shop.account.client.OrderServiceClient;
import com.online.shop.account.domain.Account;
import com.online.shop.account.domain.Order;
import com.online.shop.account.domain.User;
import com.online.shop.account.exception.AccountAlreadyExistsException;
import com.online.shop.account.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;
    private final AuthServiceClient authServiceClient;
    private final OrderServiceClient orderServiceClient;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,
                              AuthServiceClient authServiceClient,
                              OrderServiceClient orderServiceClient) {
        this.accountRepository = accountRepository;
        this.authServiceClient = authServiceClient;
        this.orderServiceClient = orderServiceClient;
    }

    @Override
    public void createAccount(User user) {
        Optional<Account> existingAccount = accountRepository.findAccountByName(user.getUsername());
        existingAccount.ifPresent(account -> {
            log.error("Account already exists");
            throw new AccountAlreadyExistsException("Account already exists ...");
        });

        authServiceClient.createUser(user);

        Account newAccount = new Account();
        newAccount.setName(user.getUsername());

        accountRepository.save(newAccount);

        log.info("New account has been created");
    }

    @Override
    public Account getAccountByName(String accountName) {
        return accountRepository.findAccountByName(accountName)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
    }

    @Override
    public List<Order> getOrders(String accountName) {
        return orderServiceClient.getOrdersByAccountName(accountName);
    }
}
