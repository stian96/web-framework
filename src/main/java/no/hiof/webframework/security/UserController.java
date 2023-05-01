package no.hiof.webframework.security;
import no.hiof.webframework.interfaces.PasswordEncryptionAlgorithm;

import java.security.SecureRandom;

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

        String connectionS = "jdbc:mysql://localhost:3001/appDB";
        UserDatabase db = new UserDatabase(connectionS, "exampleName", "examplePW");

        db.addUser(username,salt,encryptedPassword);
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
        return encryptionAlgorithm.encryptPasswordAlgorithm(password, salt);
    }

}
