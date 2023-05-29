<h1 style="color: white">API Documentation for " LogInAuthentication" class</h1>

In order to implement two-factor authentication using a unique code sent via SMS, 
the LogInAuthentication class with the ***login()*** - method can be used.
LogInAuthentication class uses the classes **FactoryAuth, SMSVerification** (which implements the **SMSCodeGenerator** interface) and 
**Authentication** (which implements the **Authenticator** interface). 
You must also import the exception class **LogInException** from the package **no.hiof.webframework.exceptions.LogInException**.
The exception class **LogInException** generates two descriptive error messages if the authentication login fails 
when using the .getMessage().

## Methods in LogInAuthentication Class
#### public boolean login(String username, String password, String phoneNumber, String code) throws LogInException
Attempts to log in a user using authentication and SMS verification.


| Parameter     | Type         | Description                                               |
|:--------------|:-------------|:----------------------------------------------------------|
| 'username'    | 'String'     | The username to authenticate                              |
| 'password'    | 'String'     | The password associated with the username                 |
| 'phoneNumber' | 'String'     | The phone number associated with the user                 |
| 'code'        | 'String'     | The verification code to check against the generated code |


| Throws             | Description                                              |
|:-------------------|:---------------------------------------------------------|
| 'LogInException'   | Generates two messages if the Authentication login fails |


<br>

## Tutorial introduction
#### Implement two-factor authentication on the login page, so that a user has to provide another form of authentication. This must be a unique code sent via SMS.

```java
public class Main {
    public static void main(String[] args) {
        String username = "Ola";
        String password = "myPw345";
        String phoneNumber = "99443322";
        String code = "644320";

        LogInAuthentication logInAuth = new LogInAuthentication();
        try {
            boolean loggedIn = logInAuth.login(username,
                    password, phoneNumber, code);
            if (loggedIn) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed.");
            }
        } catch (LogInException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
       
    }
}
```