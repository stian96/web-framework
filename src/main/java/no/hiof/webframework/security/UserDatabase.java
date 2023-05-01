package no.hiof.webframework.security;
//Scenario 3.4
import java.sql.*;
import java.sql.SQLException;
import java.util.Arrays;

public class UserDatabase {

    private Connection DbConnection;

    /**
     * Constructor for the UserDatabase class.
     */
    public UserDatabase(String myConnection, String user, String password) {
        try {
            DbConnection = DriverManager.getConnection(myConnection, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Checks whether a user exists in the database.
     *
     * @param username the name of the user to check
     * @return true if the user exists in the database, false otherwise
     */
    protected boolean userExists(String username) {

        PreparedStatement SQLstmt = null;
        ResultSet rsQry = null;
        boolean exists = false;

        try {

            SQLstmt = DbConnection.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ?");
            SQLstmt.setString(1, username);
            rsQry = SQLstmt.executeQuery();

            if (rsQry.next() && rsQry.getInt(1) > 0) {
                exists = true;
            }

            if (rsQry != null) rsQry.close();
            if (SQLstmt != null) SQLstmt.close();
            if (DbConnection != null) DbConnection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    /**
     * Saves a new user to the database with the given username, salt, and encrypted password.
     *
     * @param username          the username for the new user
     * @param salt              the salt used to encrypt the user's password
     * @param encryptedPassword the encrypted password for the new user
     */

    protected void addUser(String username, byte[] salt, byte[] encryptedPassword) {
        try {
            // Lag en PreparedStatement for å utfoere INSERT-spoerring
            PreparedStatement SQLstmt = DbConnection.prepareStatement("INSERT INTO users (username, salt, password) " +
                    "VALUES (?, ?, ?)");

            SQLstmt.setString(1, username);
            SQLstmt.setBytes(2, salt);
            SQLstmt.setBytes(3, encryptedPassword);

            SQLstmt.executeUpdate();

            SQLstmt.close();
            DbConnection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Checks if a given hashed password exists in the database for a specified username.
     *
     * @param username       the username to check
     * @param hashedPassword the hashed password to check
     * @return true if the hashed password exists in the database for the given username, otherwise false.
     */
    protected boolean checkEncryptedPasswordValueInDatabase(String username, byte[] hashedPassword) {
        ResultSet rsQry = null;
        boolean match = false;
        try {
            PreparedStatement SQLstmt = DbConnection.prepareStatement("SELECT hash FROM users WHERE username = ?");
            SQLstmt.setString(1, username);
            rsQry = SQLstmt.executeQuery();
            while (rsQry.next()) {
                byte[] hash = rsQry.getBytes("hash");
                if (Arrays.equals(hash, hashedPassword)) {
                    match = true;
                    break;
                }
            }
            SQLstmt.close();
            DbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return match;
    }
}
