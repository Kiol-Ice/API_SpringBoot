package com.loickrest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loickrest.api.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}