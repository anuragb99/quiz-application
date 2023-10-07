package com.viktor.identityservice.service;

import com.viktor.identityservice.dao.UserCredentialsDao;
import com.viktor.identityservice.entity.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {

    @Autowired
    UserCredentialsDao userCredentialsDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    public String saveUserCredentials(UserCredentials userCredentials){
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
        userCredentialsDao.save(userCredentials);
        return "User is created";

    }

    public String generateToken(String userName){
        return jwtService.generateToken(userName);

    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }

}
