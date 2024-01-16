package com.loickrest.api.service;

import java.util.List;

import com.loickrest.api.model.Team;

public interface ITeamService {
    
    public List<Team> findAllTeams();

	public Team findTeam(Long id);

	public Team createTeam(Team Team);

	public void deleteTeam(Long id);

	public Team saveTeam(Team foundTeam);
}

