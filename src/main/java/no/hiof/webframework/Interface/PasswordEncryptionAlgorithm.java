package no.hiof.webframework.Interface;
//Scenario 3.3
public interface PasswordEncryptionAlgorithm {
    byte[] encryptPw(String password, byte[] salt);
}
