package com.viktor.identityservice.controller;

import com.viktor.identityservice.entity.UserCredentials;
import com.viktor.identityservice.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserCredentialsService userCredentialsService;

    @PostMapping("/saveUser")
    public String saveUserCredetials(@RequestBody UserCredentials userCredentials){

        return userCredentialsService.saveUserCredentials(userCredentials);
    }

    @GetMapping("/token")
    public String generateToken(@RequestBody UserCredentials userCredentials){
        return userCredentialsService.generateToken(userCredentials.getName());
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        System.out.print(token);
        userCredentialsService.validateToken(token);
        return "Valid User";
    }
}
