/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.catalog.exception;

public class GenreAlreadyExistsException extends Exception {
    public GenreAlreadyExistsException(String message) {
        super(message);
    }

    public GenreAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
