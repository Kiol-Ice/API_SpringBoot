package com.loickrest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loickrest.api.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}