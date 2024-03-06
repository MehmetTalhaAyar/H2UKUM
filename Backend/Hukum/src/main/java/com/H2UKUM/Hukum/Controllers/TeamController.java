package com.H2UKUM.Hukum.Controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.H2UKUM.Hukum.Models.requests.PostAddPlayerToTeamRequest;
import com.H2UKUM.Hukum.Models.requests.PostCreateTeamRequest;
import com.H2UKUM.Hukum.Security.DefaultUser;
import com.H2UKUM.Hukum.Services.concretes.TeamService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTeam(@Valid @RequestBody PostCreateTeamRequest postCreateTeamRequest,@AuthenticationPrincipal DefaultUser currentUser){

        var createdTeam =  teamService.create(currentUser.getUserInfo(), postCreateTeamRequest);

        if(createdTeam == null) return new ResponseEntity<>(HttpStatusCode.valueOf(400));

        return new ResponseEntity<>(HttpStatusCode.valueOf(200));


    }

    @PostMapping("/addplayer")
    public ResponseEntity<?> addUserToTeam(@RequestBody PostAddPlayerToTeamRequest postAddPlayerToTeamRequest,@AuthenticationPrincipal DefaultUser currentUser){

        var isPlayerAdded = teamService.addPlayerToTeam(postAddPlayerToTeamRequest);

        if(!isPlayerAdded) return new ResponseEntity<>(HttpStatusCode.valueOf(400));

        return new ResponseEntity<>(HttpStatusCode.valueOf(200));


    }
    
}
