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

import com.loickrest.api.model.Team;
import com.loickrest.api.service.TeamService;


@RestController
public class TeamController {
	
	
	@Autowired
	private TeamService TeamService;
	
	@GetMapping("/teams")
	public List<Team> allTeams() {
				
		return this.TeamService.findAllTeams();
	}
	
	@GetMapping("/team/{id}")
	public Team oneTeam(@PathVariable Long id) {
				
		return this.TeamService.findTeam(id);
	}
	
	@PostMapping("/team")
	public Team createTeam(@RequestBody Team team) {
		
		return this.TeamService.createTeam(team);
	}
	
	@DeleteMapping("/team/{id}")
	public void deleteTeam(@PathVariable Long id) {
		
		this.TeamService.deleteTeam(id);
	}
	
	@PutMapping("/team/{id}")
	Team replaceTeam(@RequestBody Team team, @PathVariable Long id) {

		Team foundTeam = this.TeamService.findTeam(id);
		
		if (team != null) {
			
			foundTeam.setName(team.getName());
            foundTeam.setIdJoueur(team.getIdJoueur());
			foundTeam.setCurrentTournament(team.getCurrentTournament());
            foundTeam.setLevel(team.getLevel());
			
			foundTeam = this.TeamService.saveTeam(foundTeam);
		}
		
		return foundTeam;
	}
}