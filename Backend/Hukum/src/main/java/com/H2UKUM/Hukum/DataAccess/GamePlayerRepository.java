package com.H2UKUM.Hukum.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.H2UKUM.Hukum.Models.GamePlayer;

public interface GamePlayerRepository extends JpaRepository<GamePlayer,Long> {
    
}
