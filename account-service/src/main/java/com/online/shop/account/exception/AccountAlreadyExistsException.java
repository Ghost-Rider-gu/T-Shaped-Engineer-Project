/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.account.exception;

import org.springframework.security.core.AuthenticationException;

public class AccountAlreadyExistsException extends AuthenticationException {
    public AccountAlreadyExistsException(String msg, Throwable t) {
        super(msg, t);
    }

    public AccountAlreadyExistsException(String msg) {
        super(msg);
    }
}
