package no.hiof.webframework.security;

import no.hiof.webframework.interfaces.Authenticator;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;


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
     *
     */

    @Override
    public boolean authenticateLogIn(String username, String password) {
        String connectionS = "jdbc:mysql://localhost:3001/appDB";
        UserDatabase db = new UserDatabase(connectionS, "exampleName", "examplePW");

        boolean UserAuthenticated = false;

        if (db.userExists(username)) {
            Connection DBconnection = null;
            PreparedStatement SQLstmt = null;
            ResultSet rsQry = null;

            try {

                SQLstmt = DBconnection.prepareStatement("SELECT password FROM users WHERE username = ?");

                SQLstmt.setString(1, username);

                rsQry = SQLstmt.executeQuery();
                if (rsQry.next()) {
                    String passwordFromDB = rsQry.getString("password");
                    //sjekker om passord fra databasen er lik det som blir oppgitt.
                    if (passwordFromDB.equals(password)) {
                        UserAuthenticated = true;
                    }
                }

                if (rsQry != null){ rsQry.close();}
                if (SQLstmt != null) { SQLstmt.close();}
                if (DBconnection != null) { DBconnection.close();}

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return UserAuthenticated;
    }
}
