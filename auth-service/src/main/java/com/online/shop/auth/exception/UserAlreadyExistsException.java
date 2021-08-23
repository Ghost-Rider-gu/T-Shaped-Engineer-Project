/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.auth.exception;

import org.springframework.security.core.AuthenticationException;

public class UserAlreadyExistsException extends AuthenticationException {
    public UserAlreadyExistsException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
}
