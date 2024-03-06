package com.H2UKUM.Hukum.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GamePlayers")
public class GamePlayer {

    @Id
    @GeneratedValue
    @Column(name = "gamePlayerId")
    private long gamePlayerId;

    @ManyToOne
    @JoinColumn(name = "gameId",referencedColumnName = "gameId")
    private Game gameId;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "teamId",referencedColumnName = "teamId")
    private Team teamId;
    
}
