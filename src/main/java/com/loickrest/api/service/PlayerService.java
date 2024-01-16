package com.loickrest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loickrest.api.model.Player;
import com.loickrest.api.repository.PlayerRepository;

@Service
@Transactional
public class PlayerService implements IPlayerService {

	@Autowired
	private PlayerRepository PlayerRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Player> findAllPlayers() {
		
		return this.PlayerRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Player findPlayer(Long id) {
		Player result = null;

		if (id != null) {
			result = this.PlayerRepository.findById(id).orElse(null);
		} 

		return result;
	}

	@Override
	public Player createPlayer(Player player) {
		Player result = null;

		if (player != null) {
			result = this.PlayerRepository.save(player);
		} 

		return result;
	}

	@Override
	public void deletePlayer(Long id) {
		if (id != null) 
		{
			this.PlayerRepository.deleteById(id);
		}
	}

	@Override
	public Player savePlayer(Player player) {
		Player result = null;

		if (player != null) {
			result = this.PlayerRepository.save(player);
		} 

		return result;
	}
	
	
}