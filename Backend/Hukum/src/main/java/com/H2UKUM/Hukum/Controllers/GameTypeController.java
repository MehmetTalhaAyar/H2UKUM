package com.H2UKUM.Hukum.Controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.H2UKUM.Hukum.Models.requests.PostCreateGameTypeRequest;
import com.H2UKUM.Hukum.Security.DefaultUser;
import com.H2UKUM.Hukum.Services.concretes.GameTypeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/gametype")
public class GameTypeController {


    private GameTypeService gameTypeService;


    public GameTypeController(GameTypeService gameTypeService) {
        this.gameTypeService = gameTypeService;
    }



    @PostMapping("/create")
    public ResponseEntity<?> createGameType(@Valid @RequestBody PostCreateGameTypeRequest postCreateGameTypeRequest,@AuthenticationPrincipal DefaultUser currentUser){


        var user = currentUser.getUserInfo();

        if(user == null) return new ResponseEntity<String>("Error user yok",HttpStatusCode.valueOf(400));

        var createdGameType = gameTypeService.createGameType(user, postCreateGameTypeRequest);

        if(createdGameType == null) return new ResponseEntity<String>("X",HttpStatusCode.valueOf(400));

        return new ResponseEntity<String>("Game type oluşturuldu.",HttpStatusCode.valueOf(200));

        




        
    }

    




}
