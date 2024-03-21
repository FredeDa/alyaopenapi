package fr.alya.alyaopenapi.model;

/* définition de l'objet "login" */
public class Login {
    public String username;
    public String password;

    Login() {}

    Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
