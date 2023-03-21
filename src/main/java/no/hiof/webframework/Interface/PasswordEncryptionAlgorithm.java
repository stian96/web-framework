package no.hiof.webframework.Interface;

public interface PasswordEncryptionAlgorithm {
    byte[] encryptPw(String password, byte[] salt);
}
