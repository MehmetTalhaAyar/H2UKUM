package com.H2UKUM.Hukum.Services.concretes;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.H2UKUM.Hukum.DataAccess.UserRepository;
import com.H2UKUM.Hukum.Models.User;
import com.H2UKUM.Hukum.Models.requests.PostChangeUsernameRequest;

@Service
public class UserService {
    
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }


    public User findById(long id){
        return userRepository.findById(id).orElse(null);
    }


    public User changeUsername(long userId,PostChangeUsernameRequest postChangeUsernameRequest){

        User user = userRepository.findById(userId).get(); // buraya kendi exception ımızı yazabiliriz.

        if(!passwordEncoder.matches(postChangeUsernameRequest.getPassword(), user.getPassword())) return null;

        user.setUsername(postChangeUsernameRequest.getUsername());

        return userRepository.save(user);
    }

    

}
