/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "\"order\"")
public class Order {
    private static final long serialVersionUID = 227563288582556419L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @ElementCollection(targetClass = Integer.class)
    @Column(name = "items")
    private List<Integer> items;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
}
