package no.hiof.webframework.Security;
import no.hiof.webframework.Interface.PasswordEncryptionAlgorithm;

import java.security.SecureRandom;
import java.sql.*;
import java.sql.SQLException;
//Scenario 3.3
public class UserController {
    private final PasswordEncryptionAlgorithm encryptionAlgorithm;

    protected UserController(PasswordEncryptionAlgorithm encryptionAlgorithm) {
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    /**
     * Register a new user with the given username and password.
     * @param username the username for the new user
     * @param password the password for the new user*/
    protected void registerNewUser(String username, String password) {
        byte[] salt = generateSalt();
        byte[] encryptedPassword = encryptPassword(password, salt);
        saveUserToDatabase(username,salt,encryptedPassword);
    }

    /**
     * Generates a random salt*/
    protected byte[] generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    /**
     * Encrypts the password with the salt
     * @param password the password to be encrypted
     * @param salt used to add an extra layer of security to the password encryption process*/
    protected byte[] encryptPassword(String password, byte[] salt) {
        return encryptionAlgorithm.encryptPw(password, salt);
    }

    /**
     * Saves a new user to the database with the given username, salt, and encrypted password.
     * @param username the username for the new user
     * @param salt the salt used to encrypt the user's password
     * @param encryptedPassword the encrypted password for the new user
     */

    //3.4
    protected void saveUserToDatabase(String username, byte[] salt, byte[] encryptedPassword) {
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
