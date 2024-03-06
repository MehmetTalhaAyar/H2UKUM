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
@Table(name = "Tours")
public class Tour {
    
    @Id
    @GeneratedValue
    @Column(name = "tourId")
    private long tourId;

    @Column(name = "TourOrder")
    private int tourOrder;

    @ManyToOne
    @JoinColumn(name = "gameId",referencedColumnName = "gameId")
    private Game gameId;

    @Column(name = "createdOn")
    private LocalDateTime createdOn = LocalDateTime.now();

    @Column(name = "deletionStateCode")
    private int deletionStateCode = 0;

    @JsonIgnore
    @OneToMany(mappedBy = "tourId")
    private List<TourPoint> tourPoints;



}
