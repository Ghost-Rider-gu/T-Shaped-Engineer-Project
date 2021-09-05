/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.account.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class User {
    @NotNull
    @Length(min = 2)
    private String username;

    @NotNull
    @Length(min = 6)
    private String password;
}
