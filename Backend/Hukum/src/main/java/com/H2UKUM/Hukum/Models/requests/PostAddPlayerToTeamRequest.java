package com.H2UKUM.Hukum.Models.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostAddPlayerToTeamRequest {

    private Long userId;

    private Long teamId;
    
}
