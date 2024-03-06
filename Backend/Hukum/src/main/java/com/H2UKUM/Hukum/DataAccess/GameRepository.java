package com.H2UKUM.Hukum.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.H2UKUM.Hukum.Models.Game;

public interface GameRepository extends JpaRepository<Game,Long> {
    
}
