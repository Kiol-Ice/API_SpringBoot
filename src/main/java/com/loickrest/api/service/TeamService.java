package com.loickrest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loickrest.api.model.Team;
import com.loickrest.api.repository.TeamRepository;

@Service
@Transactional
public class TeamService implements ITeamService {

	@Autowired
	private TeamRepository TeamRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Team> findAllTeams() {
		
		return this.TeamRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Team findTeam(Long id) {
		Team result = null;

		if (id != null) {
			result = this.TeamRepository.findById(id).orElse(null);
		} 

		return result;
	}

	@Override
	public Team createTeam(Team player) {
		Team result = null;

		if (player != null) {
			result = this.TeamRepository.save(player);
		} 

		return result;
	}

	@Override
	public void deleteTeam(Long id) {
		if (id != null) 
		{
			this.TeamRepository.deleteById(id);
		}
	}

	@Override
	public Team saveTeam(Team player) {
		Team result = null;

		if (player != null) {
			result = this.TeamRepository.save(player);
		} 

		return result;
	}
	
	
}