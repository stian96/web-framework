package no.hiof.webframework.security;
//Scenario 3.3 og 3.4
public class User {
    private String username;
    private String password;
    private byte[] salt;
    private byte[] encryptedPassword;

    /**

     Creates a new User object with the provided username and password.
     @param username the username of the user.

     @param salt the salt used to hash the password.
     @param encryptedPassword The encrypted password.

     */
    public User(String username, byte[] salt, byte[] encryptedPassword) {
        this.username = username;
        this.salt = salt;
        this.encryptedPassword = encryptedPassword;

    }

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

    /**

     Returns the salt.
     @return the salt.
     */
    public byte[] getSalt() { return salt;}

    /**

     Sets the salt.
     @param salt to be set.
     */
    public void setSalt(byte[] salt) { this.salt = salt; }

    /**
     * Returns the encrypted password.
     *
     * @return The encrypted password.
     */
    public byte[] getEncryptedPassword() {
        return encryptedPassword;
    }

    /**
     * Sets the encrypted password.
     *
     * @param encryptedPassword The encrypted password to be set.
     */
    public void setEncryptedPassword(byte[] encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

}