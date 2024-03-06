package com.H2UKUM.Hukum.Models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Teams")
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "teamId")
    private long teamId;
    
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "teamLeadId",referencedColumnName = "userId")
    private User teamLeadId;

    @JsonIgnore
    @OneToMany(mappedBy = "teamId")
    private List<GamePlayer> gamePlayers;
    
    @JsonIgnore
    @OneToMany(mappedBy = "teamId")
    private List<TeamPlayer> teamPlayers;

    @JsonIgnore
    @OneToMany(mappedBy = "teamId")
    private List<CrewRating> crewRatings;
}
