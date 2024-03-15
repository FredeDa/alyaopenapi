package fr.alya.alyaopenapi.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.alya.alyaopenapi.model.Credentials;



@RestController
public class OpenColibController {

    @PostMapping("/axelor/callback")
    public String handleCallback(@RequestBody Credentials credentials) {
        if ("admin".equals(credentials.getUsername())&& "admin".equals(credentials.getPassword())) {
            
            return "your JSESSIONID here";
        } else {
            return "Invalid credentials";
        }
    }
    
}
