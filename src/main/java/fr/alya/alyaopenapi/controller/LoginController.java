package fr.alya.alyaopenapi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.alya.alyaopenapi.model.Login;
import fr.alya.alyaopenapi.services.JWTService;


@RestController
public class LoginController {

    @GetMapping("/login")
    public String accept() {   
        return "login";
    }

    @PostMapping("/authenticate")
    public String connexion(@RequestBody Login login) {

        
        return login.username;
   
    }

    public JWTService jwtService;

    public LoginController (JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/authentication")
    public String getToken(Authentication authentication) {
        String token = jwtService.generateToken(authentication);        
        return token;
    }
    
    

}

