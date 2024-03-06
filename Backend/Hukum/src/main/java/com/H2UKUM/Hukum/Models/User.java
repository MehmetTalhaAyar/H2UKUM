package com.H2UKUM.Hukum.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Users",uniqueConstraints = @UniqueConstraint(columnNames = {"email","username"}))
public class User {


    @Id
    @GeneratedValue
    @Column(name = "userId")
    private long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "deletionStateCode")
    private int deletionStateCode = 0;

    @Column(name = "userRoleId")
    private long userRoleId = 0;

    @Column(name = "isVerified")
    private boolean isVerified;

    @JsonIgnore
    @OneToMany(mappedBy = "createdById")
    private List<GameType> createdGameTypes;

    @JsonIgnore
    @OneToMany(mappedBy = "createdById")
    private List<Game> createdGames;

    @JsonIgnore
    @OneToMany(mappedBy = "userId")
    private List<GamePlayer> gamePlayers;

    @JsonIgnore
    @OneToMany(mappedBy = "userId")
    private List<TeamPlayer> teamPlayers;

    @JsonIgnore
    @OneToMany(mappedBy = "userId")
    private List<Player> players;
    
    @JsonIgnore
    @OneToMany(mappedBy = "userId")
    private List<Vote> votes;

    @JsonIgnore
    @OneToMany(mappedBy = "teamLeadId")
    private List<Team> leadingTeam;

}
