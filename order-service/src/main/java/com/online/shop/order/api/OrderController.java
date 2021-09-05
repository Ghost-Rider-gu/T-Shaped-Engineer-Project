/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.order.api;

import com.online.shop.order.domain.Order;
import com.online.shop.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void newOrder(@Valid @RequestBody Order order) {
        orderService.newOrder(order);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/account/{accountName}")
    public List<Order> getOrdersByAccountName(@PathVariable String accountName) {
        return orderService.getAllOrdersByAccountName(accountName);
    }
}
