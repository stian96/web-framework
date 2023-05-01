package no.hiof.webframework.interfaces;
//Scenario 3.5
/**
 * The Authenticator interface provides a contract for classes that handle user authentication.
 */
public interface Authenticator {
    boolean authenticateLogIn(String username, String password);
}
