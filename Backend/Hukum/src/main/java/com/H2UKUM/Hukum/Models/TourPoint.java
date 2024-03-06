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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TourPoints")
public class TourPoint {

    @Id
    @GeneratedValue
    @Column(name = "tourPointId")
    private long tourPointId;

    @ManyToOne
    @JoinColumn(name = "tourId",referencedColumnName = "tourId")
    private Tour tourId;

    @ManyToOne
    @JoinColumn(name = "playerId",referencedColumnName = "playerId")
    private Player playerId;

    @ManyToOne
    @JoinColumn(name = "crewRatingId",referencedColumnName = "crewRatingId")
    private CrewRating crewRatingId;
    
}
