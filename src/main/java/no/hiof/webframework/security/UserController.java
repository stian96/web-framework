package no.hiof.webframework.security;
import no.hiof.webframework.interfaces.PasswordEncryptionAlgorithm;
import java.security.SecureRandom;
//Scenario 3.3
public class UserController {
    private final PasswordEncryptionAlgorithm encryptionAlgorithm;
    /**
     * Constructor for UserController class.
     * Creates a new instance of UserController with the provided PasswordEncryptionAlgorithm implementation.
     * @param encryptionAlgorithm The PasswordEncryptionAlgorithm used for encrypting passwords.
     * */
    public UserController(PasswordEncryptionAlgorithm encryptionAlgorithm) {
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    /**
     * Register a new user with the given username and password.
     * @param username The username for the new user.
     * @param password The password for the new user.
     * */
    public void registerNewUser(String username, String password) {
        byte[] salt = generateSalt();
        byte[] encryptedPassword = encryptPassword(password, salt);

        String connectionS = "jdbc:mysql://localhost:3001/appDB";
        UserDatabase db = new UserDatabase(connectionS, "exampleName", "examplePW");
        User user = new User(username, encryptedPassword, salt);
        db.addUser(user);
    }


    /**
     * Generates a random salt.
     * @return The generated salt as a byte array.
     * */
    public byte[] generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    /**
     * Encrypts the provided password using the specified salt and the chosen encryption algorithm.
     * @param password The password to be encrypted.
     * @param salt The salt used to add an extra layer of security to the password encryption process.
     * @return The encrypted password as a byte array.
     *  */
    public byte[] encryptPassword(String password, byte[] salt) {
        return encryptionAlgorithm.encryptPasswordAlgorithm(password, salt);
    }

}
