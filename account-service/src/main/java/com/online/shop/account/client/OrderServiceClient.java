/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.account.client;

import com.online.shop.account.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/order/account/{accountName}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Order> getOrdersByAccountName(String accountName);
}
