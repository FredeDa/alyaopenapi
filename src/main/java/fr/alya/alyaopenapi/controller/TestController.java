package fr.alya.alyaopenapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/user")
    public String helloUser() {
        return "Hello User";
    }
    
    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello Admin";
    }
    

}
