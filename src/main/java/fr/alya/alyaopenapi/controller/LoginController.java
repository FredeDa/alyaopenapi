package fr.alya.alyaopenapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import fr.alya.alyaopenapi.model.Login;
// import fr.alya.alyaopenapi.services.JWTService;


@RestController
@RequestMapping("/api")
public class LoginController {
    
    /*API de test de type REST retournant le mot "login" */
    @GetMapping("/login")
    public String accept() {   
        return "login";
    }

    /*API de test de type REST pour authentifier et retourner le login de l'utilisateur en cas de réussite. */
    @PostMapping("/authenticate")
    public String connexion(@RequestBody Login login) {

        
        return login.username;
   
    }

    /* API d'authentification avec un Java Web Token  */

   /*  public JWTService jwtService;

    public LoginController (JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/authentication")
    public String getToken(Authentication authentication) {
        String token = jwtService.generateToken(authentication);        
        return token;
    } */

    /*API authentifiant l'utilisateur sur l'application axelor installée en local */

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
    
 /*    @GetMapping("/testapi")
    public String test() {   
        return "test";
    } */

}

