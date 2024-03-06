package com.H2UKUM.Hukum.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.H2UKUM.Hukum.Models.User;

public interface UserRepository extends JpaRepository<User,Long> {


    public User findByUsernameAndPassword(String email,String password);

    public User findByUsername(String username);

    public User findByEmail(String email);
    
}
