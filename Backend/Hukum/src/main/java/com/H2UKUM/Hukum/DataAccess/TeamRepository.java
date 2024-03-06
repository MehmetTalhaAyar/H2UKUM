package com.H2UKUM.Hukum.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.H2UKUM.Hukum.Models.Team;

public interface TeamRepository extends JpaRepository<Team,Long>  {
    
}
