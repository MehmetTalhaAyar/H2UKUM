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
@Table(name = "Players")
public class Player {

    @Id
    @GeneratedValue
    @Column(name = "playerId")
    private long playerId;

    @Column(name = "point")
    private int point;
    
    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User userId;

    @JsonIgnore
    @OneToMany(mappedBy = "playerId")
    private List<TourPoint> tourPoints;
    

    
}
