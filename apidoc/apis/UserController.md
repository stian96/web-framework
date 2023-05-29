<h1 style="color: white">API Documentation for "UserController" class and "UserDatabase class</h1>

In order to be able to register new users, and generate a random salt and perform encryption of the password 
together with the salt, you must use the class **UserController** and the interface **PasswordEncryptionAlgorithm**.
If you want to use the ready-made SHA encryption algorithm, you must use the **SHAPasswordEncryptionAlgorithm** class. 
Basically, the user here has the opportunity to choose his own encryption algorithm by implementing the interface 
**PasswordEncryptionAlgorithm** to his chosen class for encryption algorithm.
The ***registerNewUser()*** method is used to register a user to the database with a generated salt and encrypted 
password based on the specified encryption algorithm.

<br>
To save the encrypted password and the salt into the database, and then perform a check on whether 
the user does already exist in the database, the classes *UserController* and *UserDatabase* can be used.


## Methods in UserController
#### public void registerNewUser(String username, String password)
Register a new user with the given username and password. Includes the methods generateSalt() from 
UserController and the method addUser from the UserDatabse.

#### public byte[] generateSalt()
Generates a random salt.

#### public byte[] encryptPassword(String password, byte[] salt)
Encrypts the provided password using the specified salt and the chosen encryption algorithm.

<br>

## Methods in UserDatabase
#### public boolean userExists(String username)
Checks whether a user exists in the database.

#### public void addUser(User user)
Adds a new user to the database.

#### public boolean checkHashedPasswordValueInDatabase(String username, byte[] hashedPassword)
Checks if a given hashed password exists in the database for a specified username.

<br>

### Tutorial introduction of UserController class and registerNewUser-method
#### Create a controller whose goal is to register new users to a database. Get the password from the password field and generate a random salt and encrypt the password together with the salt.

````java
public class Main {
    public static void main(String[] args) {
        PasswordEncryptionAlgorithm encryptionAlgorithm = new SHAPasswordEncryptionAlgorithm();

        UserController userController = new UserController(encryptionAlgorithm);

        String username = "Ola";
        String password = "myPw345";

        userController.registerNewUser(username, password);

        System.out.println("New user is registered to the database!");

    }
}

````
<br>

### Tutorial introduction of UserController-and UserDatabase class with method registerNewUser.
#### Save the encrypted password and the salt into the database. Check that the user does not already exist in the database. In both situations, a message should be displayed to the user indicating what is happening.
````java
public class Main {
    public static void main(String[] args) {
        
        PasswordEncryptionAlgorithm encryptionAlgorithm = new YourEncryptionAlgorithm();
        UserController userController = new UserController(encryptionAlgorithm);
        
        String username = "Ola";
        String password = "myPw345";
        
        UserDatabase db = new UserDatabase();
        
        if (db.userExists(username)) {
            System.out.println("The user already exists in the database.");
        } else {
            userController.registerNewUser(username, password);
            System.out.println("The user is registered."); }
    }
}
````