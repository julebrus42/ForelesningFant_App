package no.ntnu.daiverse;

public class User {

    private String email;
    private String username;
    private String password;
    private String jwt;


    public User(String email, String username, String password, String jwt) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.jwt = jwt;
    }

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
