/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.processing.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Game {
    private String name;
    private String posterLink;
    private String description;
    private String releaseDate;
    private Double price;
    private int quantity;
    private int genre;
}
