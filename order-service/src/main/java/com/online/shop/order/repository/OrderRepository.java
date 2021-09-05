/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.order.repository;

import com.online.shop.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<List<Order>> getOrdersByAccountName(String accountName);
}
