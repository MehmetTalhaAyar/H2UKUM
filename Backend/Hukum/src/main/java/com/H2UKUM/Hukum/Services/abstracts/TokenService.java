package com.H2UKUM.Hukum.Services.abstracts;

import com.H2UKUM.Hukum.Models.Token;
import com.H2UKUM.Hukum.Models.UserCredentials;

public interface TokenService {
    

    public Token createToken(UserCredentials userCredentials);
}
