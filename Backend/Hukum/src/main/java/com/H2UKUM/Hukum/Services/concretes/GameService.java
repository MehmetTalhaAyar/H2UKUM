package com.H2UKUM.Hukum.Services.concretes;

import org.springframework.stereotype.Service;

import com.H2UKUM.Hukum.DataAccess.GameRepository;
import com.H2UKUM.Hukum.Models.Game;
import com.H2UKUM.Hukum.Models.User;
import com.H2UKUM.Hukum.Models.requests.PostAddPlayerToGameRequest;
import com.H2UKUM.Hukum.Models.requests.PostAddTeamToGameRequest;
import com.H2UKUM.Hukum.Models.requests.PostCreateGameRequest;

@Service
public class GameService {


    private GameRepository gameRepository;

    private GameTypeService gameTypeService;

    private GamePlayerService gamePlayerService;

    private UserService userService;

    private TeamService teamService;



    public GameService(GameRepository gameRepository, GameTypeService gameTypeService,
            GamePlayerService gamePlayerService, UserService userService) {
        this.gameRepository = gameRepository;
        this.gameTypeService = gameTypeService;
        this.gamePlayerService = gamePlayerService;
        this.userService = userService;
    }


    public Game create(User user,PostCreateGameRequest postCreateGameRequest){

        var gameType = gameTypeService.findById(postCreateGameRequest.getGameTypeId());

        if(gameType == null) return null;

        Game newGame = new Game();
        newGame.setCreatedById(user);
        newGame.setItSecret(postCreateGameRequest.getIsItSecret()); 
        newGame.setMinimize(postCreateGameRequest.getIsMinimize()); 
        newGame.setGameTypeId(gameType);

        gameRepository.save(newGame); // burada aşağısı doğru çalışmazsa yapılanların geri alınması lazım

        var isTrue = gamePlayerService.addUserToAGame(newGame, user);

        if(!isTrue) return null;
        

        return newGame;

    }


    public Boolean addPlayerToGame(PostAddPlayerToGameRequest postAddPlayerToGameRequest){

        var player = userService.findById(postAddPlayerToGameRequest.getUserId());

        if(player == null) return false;

        var game = gameRepository.findById(postAddPlayerToGameRequest.getGameId()).orElse(null);

        if(game == null) return false;

        return gamePlayerService.addUserToAGame(game, player);

    }

    public Boolean addTeamToGame(PostAddTeamToGameRequest postAddTeamToGameRequest){

        var team = teamService.findById(postAddTeamToGameRequest.getTeamId());

        if(team == null) return false;

        var game = gameRepository.findById(postAddTeamToGameRequest.getGameId()).orElse(null);

        if(game == null) return false;

        for(var eleman : team.getTeamPlayers()){

            gamePlayerService.addUserToAGame(game, eleman.getUserId());

        }

        return true;
    }






    
}
