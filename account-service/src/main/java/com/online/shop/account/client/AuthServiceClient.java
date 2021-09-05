/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.account.client;

import com.online.shop.account.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "auth-service")
public interface AuthServiceClient {
    @RequestMapping(method = RequestMethod.POST, value = "/user", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void createUser(User user);
}
