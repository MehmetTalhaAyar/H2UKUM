package com.H2UKUM.Hukum.Models.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostChangeUsernameRequest {


    // validasyon eklenecek
    private String username;

    private String password;

    
}
