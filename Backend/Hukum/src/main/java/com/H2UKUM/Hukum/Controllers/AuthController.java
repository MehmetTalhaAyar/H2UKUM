package com.H2UKUM.Hukum.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.H2UKUM.Hukum.Models.Token;
import com.H2UKUM.Hukum.Models.User;
import com.H2UKUM.Hukum.Models.requests.CreateUserRequest;
import com.H2UKUM.Hukum.Models.requests.PostLogInUserRequest;
import com.H2UKUM.Hukum.Services.concretes.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    AuthService authservice;



    public AuthController(AuthService authservice) {
        this.authservice = authservice;
    }


    @PostMapping("/create")
    public User createUser(@Valid @RequestBody CreateUserRequest user){

        return authservice.createUser(user);
        
    }

    @PostMapping("/")
    public Token logInUser(@RequestBody PostLogInUserRequest userCredentials){

        return authservice.logInUser(userCredentials);
    }
    
}
