/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.catalog.api;

import com.online.shop.catalog.domain.Game;
import com.online.shop.catalog.service.CatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogController {
    private final CatalogServiceImpl catalogService;

    @Autowired
    public CatalogController(CatalogServiceImpl catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/games/{gameName}")
    public Game getGameByName(@PathVariable String gameName) {
        return catalogService.findGameByName(gameName);
    }

    @GetMapping("/games")
    public List<Game> getAllGames() {
        return catalogService.getAllGames();
    }
}
