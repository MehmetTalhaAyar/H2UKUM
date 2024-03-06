package com.H2UKUM.Hukum.Models.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostAddPlayerToGameRequest {

    private Long userId;

    private Long gameId;
    
}
