package com.H2UKUM.Hukum.Security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.H2UKUM.Hukum.Models.User;
import com.H2UKUM.Hukum.Security.abstracts.SecurityUser;

public class DefaultUser implements SecurityUser {


    private long id;

    private String username;

    private String password;

    private long userRole; 

    private boolean enabled;

    private User userInfo;


    public DefaultUser(User user){

        this.id = user.getUserId();
        this.password = user.getPassword();
        this.userRole = user.getUserRoleId();
        this.username = user.getUsername();
        this.enabled = user.isVerified();
        this.userInfo = user;
    
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        if(userRole == 1) return AuthorityUtils.createAuthorityList("ROLE_ADMIN");

        return AuthorityUtils.createAuthorityList("ROLE_USER");

    }

    @Override
    public String getPassword() {
        
        return password;
    }

    @Override
    public String getUsername() {
        
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public long getId() {
        
        return id;
    }

    public User getUserInfo(){
        return userInfo;
    }
    
}
