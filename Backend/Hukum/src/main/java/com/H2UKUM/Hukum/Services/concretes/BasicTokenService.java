package com.H2UKUM.Hukum.Services.concretes;

import java.util.Base64;

import org.springframework.stereotype.Service;

import com.H2UKUM.Hukum.Models.Token;
import com.H2UKUM.Hukum.Models.UserCredentials;
import com.H2UKUM.Hukum.Services.abstracts.TokenService;

@Service
public class BasicTokenService implements TokenService {

    @Override
    public Token createToken(UserCredentials userCredentials) {
        
        String tokenContent = userCredentials.getUsername() + ":" + userCredentials.getPassword();
        
        Token token = new Token();
        token.setPrefix("Basic");
        token.setToken(Base64.getEncoder().encodeToString(tokenContent.getBytes()));

        return token;

    }
    
}
