package no.hiof.webframework.Security;

import no.hiof.webframework.Interface.Authenticator;
/**
 * The Authentication class handles user authentication.
 */
public class Authentication implements Authenticator {
    /**
     * Authenticates a user with a given username and password.
     *
     * @param username the username to authenticate.
     * @param password the password associated with the username.
     * @return true if the user is authenticated, false otherwise.
     */
    @Override
    public boolean authenticateLogIn(String username, String password) {
        // Valider brukernavn og passord
        return false;
    }
}
