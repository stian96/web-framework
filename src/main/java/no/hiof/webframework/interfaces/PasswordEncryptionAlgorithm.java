package no.hiof.webframework.interfaces;
//Scenario 3.3
public interface PasswordEncryptionAlgorithm {
    byte[] encryptPasswordAlgorithm(String password, byte[] salt);
}
