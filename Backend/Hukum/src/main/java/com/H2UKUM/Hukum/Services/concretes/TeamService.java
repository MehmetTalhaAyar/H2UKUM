package com.H2UKUM.Hukum.Services.concretes;

import org.springframework.stereotype.Service;

import com.H2UKUM.Hukum.DataAccess.TeamRepository;
import com.H2UKUM.Hukum.Models.Team;
import com.H2UKUM.Hukum.Models.User;
import com.H2UKUM.Hukum.Models.requests.PostAddPlayerToTeamRequest;
import com.H2UKUM.Hukum.Models.requests.PostCreateTeamRequest;

@Service
public class TeamService {
    

    private TeamRepository teamRepository;

    private TeamPlayerService teamPlayerService;

    private UserService userService;



    public TeamService(TeamRepository teamRepository, TeamPlayerService teamPlayerService, UserService userService) {
        this.teamRepository = teamRepository;
        this.teamPlayerService = teamPlayerService;
        this.userService = userService;
    }

    public Team create(User teamLead,PostCreateTeamRequest postCreateTeamRequest){

        Team newTeam = new Team();
        newTeam.setName(postCreateTeamRequest.getName());
        newTeam.setTeamLeadId(teamLead);
        
        var createdTeam = teamRepository.save(newTeam);

        if(createdTeam == null) return null;

        var isPlayerAdded = teamPlayerService.addUserToTeam(newTeam, teamLead);

        if(!isPlayerAdded) return null;

        return createdTeam;
        
    }

    public Boolean addPlayerToTeam(PostAddPlayerToTeamRequest postAddPlayerToTeamRequest){

        var player = userService.findById(postAddPlayerToTeamRequest.getUserId());

        if(player == null) return false;

        var team = teamRepository.findById(postAddPlayerToTeamRequest.getTeamId()).orElse(null);

        if(team == null) return false;

        return teamPlayerService.addUserToTeam(team, player);
    }

    public Team findById(long id){
        return teamRepository.findById(id).orElse(null);
    }




}
