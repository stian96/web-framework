package no.hiof.webframework.Interface;
/**
 * The Authenticator interface provides a contract for classes that handle user authentication.
 */
public interface Authenticator {
    boolean authenticateLogIn(String username, String password);
}
