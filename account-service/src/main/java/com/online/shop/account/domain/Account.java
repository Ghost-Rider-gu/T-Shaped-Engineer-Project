/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.account.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = 217783288582556459L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Email
    @Column(name = "email")
    private String email;
}
