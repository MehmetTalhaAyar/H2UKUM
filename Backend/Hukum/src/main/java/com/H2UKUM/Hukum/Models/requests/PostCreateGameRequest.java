package com.H2UKUM.Hukum.Models.requests;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateGameRequest {

    private long gameTypeId;

    private Boolean isMinimize;

    private Boolean isItSecret;



}
