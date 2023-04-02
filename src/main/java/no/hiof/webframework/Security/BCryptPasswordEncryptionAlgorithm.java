package no.hiof.webframework.Security;
//Example class of an EncryptionAlgorithm
//Scenario 3.3-eksempel.
import no.hiof.webframework.Interface.PasswordEncryptionAlgorithm;
/**
 Implementation of the PasswordEncryptionAlgorithm interface that encrypts passwords using the BCrypt algorithm.
 The BCrypt algorithm: hashes passwords with a random salt and a configurable number of rounds.
 */
//import org.mindrot.jbcrypt.BCrypt;

public class BCryptPasswordEncryptionAlgorithm implements PasswordEncryptionAlgorithm {
    /**
     * Encrypts a given password using the BCrypt algorithm.
     * @param password The text password to be encrypted.
     * @param salt A byte array representing the salt to be used in the encryption process.
     */
    // The number of rounds of hashing to use in the BCrypt algorithm
    private static final int BCRYPT_ROUNDS = 12;
    public byte[] encryptPw(String password, byte[] salt) {
       /*

       // Convert the salt to a string for use in the BCrypt algorithm

        String saltString = new String(salt);

        // Hash the password with the BCrypt algorithm

        String hashedPassword = BCrypt.hashpw(password, saltString, BCRYPT_ROUNDS);

        // Convert the hashed password back to a byte array and return it

        return hashedPassword.getBytes();

        */
        return salt;
    }

}
