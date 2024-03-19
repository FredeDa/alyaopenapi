package fr.alya.alyaopenapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

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

   /*  public JWTService jwtService;

    public LoginController (JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/authentication")
    public String getToken(Authentication authentication) {
        String token = jwtService.generateToken(authentication);        
        return token;
    } */

    @PostMapping("/loginaxelor")
    public String login(@RequestBody  Login login) {

    WebClient.Builder builder = WebClient.builder();

		String callback = builder.build()
					.post()
					.uri("http://localhost:8080/axelor/callback")
                    .body(BodyInserters.fromValue(login))
					.retrieve()
					.bodyToMono(String.class)
                    .block();
		
		System.out.println("------------------------------------------------");
		System.out.println(callback);
		System.out.println("------------------------------------------------");

	return callback;

    }
    
    

}

