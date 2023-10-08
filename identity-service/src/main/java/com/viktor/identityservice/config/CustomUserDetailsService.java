package com.viktor.identityservice.config;

import com.viktor.identityservice.dao.UserCredentialsDao;
import com.viktor.identityservice.entity.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserCredentialsDao userCredentialsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> userCredentials = userCredentialsDao.findByName(username);
        return userCredentials.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found with name:" + username));
    }
}
