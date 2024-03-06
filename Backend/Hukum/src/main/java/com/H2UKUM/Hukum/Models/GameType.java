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


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GameTypes")
public class GameType {

    @Id
    @GeneratedValue
    @Column(name = "gameTypeId")
    private long gameTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "isItVerified")
    private boolean isItVerified = false;

    @Column(name = "createdOn")
    private LocalDateTime createdOn = LocalDateTime.now();

    @Column(name = "deletionStateCode")
    private int deletionStateCode = 0;

    @ManyToOne
    @JoinColumn(name = "createdById",referencedColumnName = "userId")
    private User createdById;

    @JsonIgnore
    @OneToMany
    private List<Game> games; 


    
}
