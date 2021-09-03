/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.catalog.repository;

import com.online.shop.catalog.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findGameByName(String gameName);
}
