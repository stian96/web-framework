package no.hiof.webframework.Security;
//Scenario 3.4
import java.sql.*;
import java.sql.SQLException;
public class UserDatabase {
    /**
     * Constructor for the UserDatabase class.
     */
    protected void UserDatabase() {
    }

    /**
     * Checks whether a user exists in the database.
     *
     * @param username the name of the user to check
     * @return true if the user exists in the database, false otherwise
     */

    protected static boolean userExists(String username) {
        Connection DBconnection = null;
        PreparedStatement SQLstmt = null;
        ResultSet rsQry = null;
        boolean exists = false;

        try {
            DBconnection = DriverManager.getConnection("jdbc:mysql://localhost:3001/appDB",
                    "exampleName", "examplePW");

            SQLstmt = DBconnection.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ?");

            SQLstmt.setString(1, username);

            rsQry= SQLstmt.executeQuery();
            if(rsQry.next() && rsQry.getInt(1)>0){
                exists = true;
            }

            if (rsQry!=null) rsQry.close();
            if (SQLstmt!=null) SQLstmt.close();
            if (DBconnection!=null) DBconnection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    /**
     * Saves a new user to the database with the given username, salt, and encrypted password.
     * @param username the username for the new user
     * @param salt the salt used to encrypt the user's password
     * @param encryptedPassword the encrypted password for the new user
     */


    protected static void addUser(String username, byte[] salt, byte[] encryptedPassword) {
        try {
            // Opprett en JDBC-tilkobling til databasen
            Connection DBconnection = DriverManager.getConnection("jdbc:mysql://localhost:3001/appDB",
                    "exampleName", "examplePW");

            // Lag en PreparedStatement for å utfoere INSERT-spoerring
            PreparedStatement SQLstmt = DBconnection.prepareStatement("INSERT INTO users (username, salt, password) " +
                    "VALUES (?, ?, ?)");

            SQLstmt.setString(1, username);
            SQLstmt.setBytes(2, salt);
            SQLstmt.setBytes(3, encryptedPassword);

            SQLstmt.executeUpdate();

            SQLstmt.close();
            DBconnection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
