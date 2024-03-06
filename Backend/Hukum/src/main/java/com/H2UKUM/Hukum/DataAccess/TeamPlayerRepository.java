package com.H2UKUM.Hukum.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.H2UKUM.Hukum.Models.TeamPlayer;

public interface TeamPlayerRepository extends JpaRepository<TeamPlayer,Long> {
    
}
