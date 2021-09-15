/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.processing.processor;

import com.online.shop.processing.domain.Game;
import org.springframework.batch.item.ItemProcessor;

public class ProductItemProcessor implements ItemProcessor<Game, Game> {
    @Override
    public Game process(Game game) throws Exception {
        return game;
    }
}
