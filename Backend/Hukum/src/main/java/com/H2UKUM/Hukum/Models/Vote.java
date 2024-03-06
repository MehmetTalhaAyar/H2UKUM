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
@Table(name = "Votes")
public class Vote {
    
    @Id
    @GeneratedValue
    @Column(name = "voteId")
    private long voteId;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "pollingCandidateId",referencedColumnName = "pollingCandidateId")
    private PollingCandidate pollingCandidateId;
}
