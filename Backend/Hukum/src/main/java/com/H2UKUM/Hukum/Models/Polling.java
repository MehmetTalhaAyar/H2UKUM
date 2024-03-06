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
@Table(name = "Pollings")
public class Polling {

    @Id
    @GeneratedValue
    @Column(name = "pollingId")
    private long pollingId;

    @ManyToOne
    @JoinColumn(name = "gameId",referencedColumnName = "gameId")
    private Game gameId;
    
    @Column(name = "finishedTime")
    private LocalDateTime finishedTime;

    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;

    @Column(name = "isMulti")
    private boolean isMulti;

    @Column(name = "isVisible")
    private boolean isVisible;

    @JsonIgnore
    @OneToMany(mappedBy = "pollingId")
    private List<PollingCandidate> candidates;

}
