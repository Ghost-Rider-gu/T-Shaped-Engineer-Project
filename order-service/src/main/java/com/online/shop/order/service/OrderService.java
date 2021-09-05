/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.order.service;

import com.online.shop.order.domain.Order;

import java.util.List;

public interface OrderService {
    void newOrder(Order order);
    List<Order> getAllOrders();
    List<Order> getAllOrdersByAccountName(String accountName);
    Order getOrderById(Long id);
}
