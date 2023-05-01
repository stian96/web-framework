package no.hiof.webframework.Security;
//class of an EncryptionAlgorithm
//Scenario 3.3

import no.hiof.webframework.interfaces.PasswordEncryptionAlgorithm;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

/**
 Implementation of the PasswordEncryptionAlgorithm interface that encrypts passwords using the SHA algorithm.
 The SHA algorithm: Produces a hash value by taking an input message,
 dividing it into blocks and performing mathematical operations on each block.
 */

public class SHAPasswordEncryptionAlgorithm implements PasswordEncryptionAlgorithm {
    /**
     * Encrypts a given password with SHA-256 algorithm.
     * @param password The password to be encrypted.
     * @param salt A byte array representing the salt to be used in the encryption process.
     */

    private  static final String SHA_ALGR= "SHA-256";
    public byte[] encryptPasswordAlgorithm(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance(SHA_ALGR);
            return md.digest((password + new String(salt)).getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
