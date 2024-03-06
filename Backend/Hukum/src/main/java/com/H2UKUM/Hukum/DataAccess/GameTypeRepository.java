package com.H2UKUM.Hukum.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.H2UKUM.Hukum.Models.GameType;

public interface GameTypeRepository extends JpaRepository<GameType,Long> {
    
}
