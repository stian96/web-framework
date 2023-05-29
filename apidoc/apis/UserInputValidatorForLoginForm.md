<h1 style="color: white">API Documentation for "UserInputValidatorForLoginForm" Class</h1>

To be able to input-validate username and password fields, you must use the class **UserInputValidatorForLoginForm**
in the package **no.hiof.webframework.security**.

## Methods
#### 'validateUsername(String username)'
The method that can be used to validate a name. It checks that the length of the field is between the interval 5 – 20 characters.

| Parameter    | Type         | Description                                           |
|:-------------|:-------------|:------------------------------------------------------|
| 'username'   | 'String'     | The username that needs to be validated                      |


<br>

#### 'validatePassword(String password)'
The method that can be used to validate a password. It also considers whether the length is between 5 and 20 characters,
as well as whether the field contains alphanumeric characters (a-z, A-Z, 0-9).

| Parameter    | Type         | Description                             |
|:-------------|:-------------|:----------------------------------------|
| 'password'   | 'String'     | The password that needs to be validated |

<br>

## Tutorial introduction
#### Input-validate the username and password fields. This can be done by checking that the length of the fields is between 5 - 20, and that the password contains a combination of numbers and characters. This can be done by implementing a rule that checks that the password only contains alphanumeric characters (a-z, A-Z, 0-9).

```java
public class Main {
    public static void main(String[] args) {
        String username = "Ola";
        String password = "myPw345";

        UserInputValidatorForLoginForm validator = new UserInputValidatorForLoginForm();

        if(validator.validateUsername(username)) {
            System.out.println("Valid username");
        } else {
            System.out.println(
                    "Invalid username, Enter a string between 5-20 letters.");
        }
        if(validator.validatePassword(password)) {
            System.out.println("Valid password");
        } else {
            System.out.println(
                    "Invalid password, should contain alphanumeric characters");
        }
    }
}
```
