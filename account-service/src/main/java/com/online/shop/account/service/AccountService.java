/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.account.service;

import com.online.shop.account.domain.Account;
import com.online.shop.account.domain.Order;
import com.online.shop.account.domain.User;

import java.util.List;

public interface AccountService {
    void createAccount(User user);
    Account getAccountByName(String accountName);
    List<Order> getOrders(String accountName);
}
