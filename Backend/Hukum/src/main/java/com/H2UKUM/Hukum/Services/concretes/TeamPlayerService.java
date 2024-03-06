package com.H2UKUM.Hukum.Services.concretes;

import org.springframework.stereotype.Service;

import com.H2UKUM.Hukum.DataAccess.TeamPlayerRepository;
import com.H2UKUM.Hukum.Models.Team;
import com.H2UKUM.Hukum.Models.TeamPlayer;
import com.H2UKUM.Hukum.Models.User;

@Service
public class TeamPlayerService {
    
    private TeamPlayerRepository teamPlayerRepository;

    public TeamPlayerService(TeamPlayerRepository teamPlayerRepository) {
        this.teamPlayerRepository = teamPlayerRepository;
    }


    public Boolean addUserToTeam(Team team,User user){

        TeamPlayer newTeamPlayer = new TeamPlayer();
        newTeamPlayer.setTeamId(team);
        newTeamPlayer.setUserId(user);

        var addedPlayer = teamPlayerRepository.save(newTeamPlayer);

        if(addedPlayer == null) return false;

        return true;

    }

    


}
