package no.hiof.webframework.Interface;
//Scenario 3.3
public interface PasswordEncryptionAlgorithm {
    byte[] encryptPasswordAlgorithm(String password, byte[] salt);
}
