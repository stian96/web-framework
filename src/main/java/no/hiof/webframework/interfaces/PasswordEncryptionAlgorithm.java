package no.hiof.webframework.interfaces;
/**
 * The PasswordEncryptionAlgorithm interface represents an algorithm used for encrypting passwords.
 */
public interface PasswordEncryptionAlgorithm {
    /**
     * Encrypts the provided password using the specified salt.
     * @param password The password to be encrypted.
     * @param salt     The salt value to be used in the encryption process.
     * */
    byte[] encryptPasswordAlgorithm(String password, byte[] salt);
}
