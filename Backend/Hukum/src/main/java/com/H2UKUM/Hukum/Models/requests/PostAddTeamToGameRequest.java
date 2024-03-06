package com.H2UKUM.Hukum.Models.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostAddTeamToGameRequest {

    private Long teamId;

    private Long gameId;
    
}
