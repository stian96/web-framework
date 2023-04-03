package no.hiof.webframework.Security;
//Scenario 3.3 og 3.4
public class User {
    private String username;
    private String password;

    /**

     Creates a new User object with the provided username and password.
     @param username the username of the user
     @param password the password of the user

     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    /**

     Returns the username of the user.
     @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**

     Sets the username of the user.
     @param username the new username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}