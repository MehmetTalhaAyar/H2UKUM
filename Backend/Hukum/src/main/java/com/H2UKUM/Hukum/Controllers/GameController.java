package com.H2UKUM.Hukum.Controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.H2UKUM.Hukum.Models.requests.PostAddPlayerToGameRequest;
import com.H2UKUM.Hukum.Models.requests.PostAddTeamToGameRequest;
import com.H2UKUM.Hukum.Models.requests.PostCreateGameRequest;
import com.H2UKUM.Hukum.Security.DefaultUser;
import com.H2UKUM.Hukum.Services.concretes.GameService;

@RestController
@RequestMapping("/api/v1/game")
public class GameController {


    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }



    @PostMapping("/create")
    public ResponseEntity<?> createGame(@RequestBody PostCreateGameRequest postCreateGameRequest,@AuthenticationPrincipal DefaultUser currentUser){

        var createdGame = gameService.create(currentUser.getUserInfo(),postCreateGameRequest);

        if(createdGame == null) return null;


        return new ResponseEntity<>(HttpStatusCode.valueOf(200));

    }


    @PostMapping("/addplayer")
    public ResponseEntity<?> addPlayerToGame(@RequestBody PostAddPlayerToGameRequest postAddPlayerToGameRequest,@AuthenticationPrincipal DefaultUser currentUser){
        
        // burada oyuna katılması için istek atacak şuan direk oyuna ekliyoruz
        // ekleyen kişinin oyunun içinde olup olmadığı kontrol edilecek

        var isPlayerAdded = gameService.addPlayerToGame(postAddPlayerToGameRequest);

        if(!isPlayerAdded) return new ResponseEntity<>(HttpStatusCode.valueOf(400));


        return new ResponseEntity<>(HttpStatusCode.valueOf(200));

    }

    @PostMapping("/addteam")
    public ResponseEntity<?> addTeamToGame(@RequestBody PostAddTeamToGameRequest postAddTeamToGameRequest,@AuthenticationPrincipal DefaultUser currentUser){

        //istek atan kullanıcının oyunun içindeki oyunculardan olduğu kontrol edilecek
        //burada oyuna katılması için kullanıcıların hepsine istek atılacak

        var isTeamAdded = gameService.addTeamToGame(postAddTeamToGameRequest);

        if(!isTeamAdded) return new ResponseEntity<>(HttpStatusCode.valueOf(400));

        return new ResponseEntity<>(HttpStatusCode.valueOf(200));

    }



    
}
