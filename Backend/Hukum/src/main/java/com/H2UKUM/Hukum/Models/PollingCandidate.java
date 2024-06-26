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
@Table(name = "PollingCandidates")
public class PollingCandidate {

    @Id
    @GeneratedValue
    @Column(name = "pollingCandidateId")
    private long pollingCandidateId;

    @ManyToOne
    @JoinColumn(name = "pollingId",referencedColumnName = "pollingId")
    private Polling pollingId;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "pollingCandidateId")
    private List<Vote> votes;
    
}
