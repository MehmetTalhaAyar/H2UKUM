package com.H2UKUM.Hukum.Services.concretes;

import org.springframework.stereotype.Service;

import com.H2UKUM.Hukum.DataAccess.GamePlayerRepository;
import com.H2UKUM.Hukum.Models.Game;
import com.H2UKUM.Hukum.Models.GamePlayer;
import com.H2UKUM.Hukum.Models.User;

@Service
public class GamePlayerService {


    private GamePlayerRepository gamePlayerRepository;

    public GamePlayerService(GamePlayerRepository gamePlayerRepository) {
        this.gamePlayerRepository = gamePlayerRepository;
    }


    public Boolean addUserToAGame(Game game,User user){

        GamePlayer newGamePlayer = new GamePlayer();
        newGamePlayer.setGameId(game);
        newGamePlayer.setUserId(user);
        newGamePlayer.setTeamId(null);

        var createdGamePlayer = gamePlayerRepository.save(newGamePlayer);

        if(createdGamePlayer == null) return false;

        return true;

    }

    



}
