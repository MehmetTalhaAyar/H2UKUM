package com.H2UKUM.Hukum.Security.abstracts;

import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityUser extends UserDetails {


    public long getId();
    
}
