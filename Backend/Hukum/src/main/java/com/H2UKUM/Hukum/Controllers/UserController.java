package com.H2UKUM.Hukum.Controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.H2UKUM.Hukum.Models.User;
import com.H2UKUM.Hukum.Models.requests.PostChangeUsernameRequest;
import com.H2UKUM.Hukum.Security.DefaultUser;
import com.H2UKUM.Hukum.Services.concretes.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }




    @PutMapping("/changeusername")
    public ResponseEntity<?> updateUser(@Valid @RequestBody PostChangeUsernameRequest postChangeUsernameRequest,@AuthenticationPrincipal DefaultUser currentUser){


        var user = userService.findById(currentUser.getId());

        if(user == null) return null; // geri dönüş ayarlanacak

        var updatedUser = userService.changeUsername(user.getUserId(),postChangeUsernameRequest);

        if(updatedUser == null) return null;

        return new ResponseEntity<User>(updatedUser,HttpStatusCode.valueOf(200));
    }
    
}
