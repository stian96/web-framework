package no.hiof.webframework.security;
//Scenario 3.3 og 3.4
public class User {
    private String username;
    private String password;
    private String salt;

    /**

     Creates a new User object with the provided username and password.
     @param username the username of the user
     @param password the password of the user
     @param salt the salt used to hash the password

     */
    public User(String username, String password, String salt) {
        this.username = username;
        this.password = password;
        this.salt = salt;

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
    /**

     Returns the password of the user.
     @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**

     Sets the password to the user.
     @param password to the user to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**

     Returns the salt.
     @return the salt.
     */
    public String getSalt() { return salt;}

    /**

     Sets the salt.
     @param salt to be set.
     */
    public void setSalt(String salt) { this.salt = salt; }

}