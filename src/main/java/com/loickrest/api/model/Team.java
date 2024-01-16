package com.loickrest.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    // TODO List avec relation
    @Column(name="id_joueur")
    private Long idJoueur;

    private String name;

    @Column(name="current_tournament")
    private String currentTournament;

    private teamLevel level;

}

enum teamLevel {
    regional,
    national,
    international
}



