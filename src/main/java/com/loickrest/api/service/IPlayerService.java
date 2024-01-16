package com.loickrest.api.service;

import java.util.List;

import com.loickrest.api.model.Player;

public interface IPlayerService {
    
    public List<Player> findAllPlayers();

	public Player findPlayer(Long id);

	public Player createPlayer(Player Player);

	public void deletePlayer(Long id);

	public Player savePlayer(Player foundPlayer);
}

