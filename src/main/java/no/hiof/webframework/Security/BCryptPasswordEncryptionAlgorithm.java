package no.hiof.webframework.Security;
//Example class of an EncryptionAlgorithm
//Scenario 3.5-eksempel.
import no.hiof.webframework.Interface.PasswordEncryptionAlgorithm;
/**
 Implementation of the PasswordEncryptionAlgorithm interface that encrypts passwords using the BCrypt algorithm.
 The BCrypt algorithm: hashes passwords with a random salt and a configurable number of rounds.
 */
public class BCryptPasswordEncryptionAlgorithm implements PasswordEncryptionAlgorithm {
    /**
     * Encrypts a given password using the BCrypt algorithm.
     * @param password The text password to be encrypted.
     * @param salt A byte array representing the salt to be used in the encryption process.
     */
    public byte[] encryptPw(String password, byte[] salt) {
    // Implementer logikken for å kryptere passordet med bcrypt-algoritmen
    // Satt til retun salt nå, fordi den mangler full implementering
        return salt;
    }
}
