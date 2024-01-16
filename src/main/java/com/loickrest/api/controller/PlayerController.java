package com.loickrest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loickrest.api.model.Player;
import com.loickrest.api.service.PlayerService;


@RestController
public class PlayerController {
	
	
	@Autowired
	private PlayerService PlayerService;
	
	@GetMapping("/players")
	public List<Player> allPlayers() {
				
		return this.PlayerService.findAllPlayers();
	}
	
	@GetMapping("/player/{id}")
	public Player onePlayer(@PathVariable Long id) {
				
		return this.PlayerService.findPlayer(id);
	}
	
	@PostMapping("/player")
	public Player createPlayer(@RequestBody Player player) {
		
		return this.PlayerService.createPlayer(player);
	}
	
	@DeleteMapping("/player/{id}")
	public void deletePlayer(@PathVariable Long id) {
		
		this.PlayerService.deletePlayer(id);
	}
	
	@PutMapping("/player/{id}")
	Player replacePlayer(@RequestBody Player player, @PathVariable Long id) {

		Player foundPlayer = this.PlayerService.findPlayer(id);
		
		if (player != null) {
			
			foundPlayer.setLastName(player.getLastName());
			foundPlayer.setFirstName(player.getFirstName());
			foundPlayer.setIdTeam(player.getIdTeam());
			foundPlayer.setPosition(player.getPosition());
			
			foundPlayer = this.PlayerService.savePlayer(foundPlayer);
		}
		
		return foundPlayer;
	}
}