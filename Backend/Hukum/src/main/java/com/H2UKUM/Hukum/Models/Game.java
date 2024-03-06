package com.H2UKUM.Hukum.Models;


import java.time.LocalDateTime;
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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Games")
public class Game {

    @Id
    @GeneratedValue
    @Column(name = "gameId")
    private long gameId;

    @ManyToOne
    @JoinColumn(name = "gameTypeId", referencedColumnName ="gameTypeId")
    private GameType gameTypeId;


    @Column(name = "isItDone")
    private boolean isItDone = false;

    @ManyToOne
    @JoinColumn(name = "createdById", referencedColumnName = "userId")
    private User createdById;

    @Column(name = "createdOn")
    private LocalDateTime createdOn = LocalDateTime.now();

    @Column(name = "isMinimize")
    private boolean isMinimize = false;

    @Column(name = "isItSecret")
    private boolean isItSecret = false;

    @Column(name = "deletionStateCode")
    private int deletionStateCode = 0;

    @JsonIgnore
    @OneToMany(mappedBy = "gameId")
    private List<GamePlayer> gamePlayers;

    @JsonIgnore
    @OneToMany
    private List<Tour> tours;

    @JsonIgnore
    @OneToMany
    private List<Polling> pollings;

}
