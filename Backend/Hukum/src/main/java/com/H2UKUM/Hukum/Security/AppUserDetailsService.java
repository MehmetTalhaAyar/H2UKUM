package com.H2UKUM.Hukum.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.H2UKUM.Hukum.Models.User;
import com.H2UKUM.Hukum.Services.concretes.UserService;

@Service
public class AppUserDetailsService implements UserDetailsService {

    UserService userService;



    public AppUserDetailsService(UserService userService) {
        this.userService = userService;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User inDB = userService.findByUsername(username);

        if(inDB == null){
            throw new UsernameNotFoundException(username + " is not found");
        }


        return new DefaultUser(inDB);

    }
    
}
