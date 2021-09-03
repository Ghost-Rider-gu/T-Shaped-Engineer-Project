/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.catalog.service;

import com.online.shop.catalog.domain.Game;

import java.util.List;

public interface CatalogService {
    void addGenre(String genreName);
    void addGame(Game newGame);
    void updateGame(Game newGame);
    List<Game> getAllGames();
    Game findGameByName(String gameName);
}
