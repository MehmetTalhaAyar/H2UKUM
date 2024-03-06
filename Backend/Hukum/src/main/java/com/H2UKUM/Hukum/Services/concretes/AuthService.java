package com.H2UKUM.Hukum.Services.concretes;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.H2UKUM.Hukum.DataAccess.UserRepository;
import com.H2UKUM.Hukum.Models.Token;
import com.H2UKUM.Hukum.Models.User;
import com.H2UKUM.Hukum.Models.UserCredentials;
import com.H2UKUM.Hukum.Models.requests.CreateUserRequest;
import com.H2UKUM.Hukum.Models.requests.PostLogInUserRequest;
import com.H2UKUM.Hukum.Services.abstracts.TokenService;


@Service
public class AuthService {

    private UserRepository userRepository;

    private TokenService tokenService;

    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,TokenService tokenService,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(CreateUserRequest user){

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setVerified(true);
        return userRepository.save(newUser);
    }

    public Token logInUser(PostLogInUserRequest userCredentials){

        var user = userRepository.findByUsername(userCredentials.getUsername());
        if(user == null) return null;


        if(!passwordEncoder.matches(userCredentials.getPassword(), user.getPassword())) return null;
        UserCredentials userCredentialsfortoken = new UserCredentials();
        userCredentialsfortoken.setPassword(userCredentials.getPassword());
        userCredentialsfortoken.setUsername(userCredentials.getUsername());

        return tokenService.createToken(userCredentialsfortoken);
        
    }
    


    
}
