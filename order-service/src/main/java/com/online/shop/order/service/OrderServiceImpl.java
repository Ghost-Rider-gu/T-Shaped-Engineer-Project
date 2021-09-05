/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.order.service;

import com.online.shop.order.domain.Order;
import com.online.shop.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void newOrder(Order order) {
        orderRepository.save(order);
        log.info("A new order has been created");
    }

    @Override
    public List<Order> getAllOrders() {
        log.info("Getting all orders ...");
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getAllOrdersByAccountName(String accountName) {
        Optional<List<Order>> orders = orderRepository.getOrdersByAccountName(accountName);
        if (orders.isPresent()) {
            log.info("Got orders by account name '{}'", accountName);
            return orders.get();
        } else {
            log.error("Couldn't get orders by account name");
            throw new EntityNotFoundException("Orders not found");
        }
    }

    @Override
    public Order getOrderById(Long id) {
        log.info("Got an order by '{}' id", id);
        return orderRepository.getOne(id);
    }
}
