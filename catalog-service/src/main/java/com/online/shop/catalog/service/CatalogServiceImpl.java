/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.catalog.service;

import com.online.shop.catalog.domain.Game;
import com.online.shop.catalog.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {
    private static final Logger log = LoggerFactory.getLogger(CatalogServiceImpl.class);

    private final GameRepository gameRepository;

    @Autowired
    public CatalogServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void addGenre(String genreName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addGame(Game newGame) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateGame(Game newGame) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Game> getAllGames() {
        log.info("Getting list of games ...");
        return gameRepository.findAll();
    }

    @Override
    public Game findGameByName(String gameName) {
        Optional<Game> existingGame = gameRepository.findGameByName(gameName);
        if (existingGame.isPresent()) {
            log.info("Got a game '{}'", gameName);
            return existingGame.get();
        } else {
            log.error("Couldn't find a game '{}'", gameName);
            throw new EntityNotFoundException(String.format("Game: [%s] not found", gameName));
        }
    }
}
