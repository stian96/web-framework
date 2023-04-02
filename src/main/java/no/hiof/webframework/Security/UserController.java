package no.hiof.webframework.Security;

//import org.mindrot.jbcrypt.BCrypt;

import no.hiof.webframework.Interface.PasswordEncryptionAlgorithm;

//Scenario 3.3
public class UserController {
    private final PasswordEncryptionAlgorithm encryptionAlgorithm;

    protected UserController(PasswordEncryptionAlgorithm encryptionAlgorithm) {
        this.encryptionAlgorithm = encryptionAlgorithm;

    }

    /**
     * Register a new user with the given username and password
     * @param username the username for the new user
     * @param password the password for the new user*/
    protected void registerNewUser(String username, String password) {
    }

    /**
     * Generates a random salt*/
    protected byte[] generateSalt() {
        return new byte[16];
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
    protected void saveUserToDatabase(String username, byte[] salt, byte[] encryptedPassword) {
    }

}
