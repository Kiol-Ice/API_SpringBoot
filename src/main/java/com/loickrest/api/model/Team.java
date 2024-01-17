package com.loickrest.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Player> playerList;

    private String name;

    @Column(name="current_tournament")
    private String currentTournament;

    private TeamLevel level;

    public Team(String name, String currentTournament, TeamLevel level) {
        this.name = name;
        this.currentTournament = currentTournament;
        this.level = level;
    }

}
