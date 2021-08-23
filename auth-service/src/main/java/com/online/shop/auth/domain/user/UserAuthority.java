/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.auth.domain.user;

public enum UserAuthority {
    ADMIN("Super Admin"),
    USER("Customer");

    private final String authority;

    UserAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }
}
