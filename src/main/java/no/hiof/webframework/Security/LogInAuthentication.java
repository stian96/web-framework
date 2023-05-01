package no.hiof.webframework.Security;
//Scenario 3.5
import no.hiof.webframework.interfaces.Authenticator;
import no.hiof.webframework.interfaces.SMSCodeGenerator;
import no.hiof.webframework.exceptions.LogInException;
/**
 * The LogInAuthentication class handles user login using authentication and SMS verification.
 */
public class LogInAuthentication {
    private Authenticator auth;
    private SMSCodeGenerator codeGenerator;
    /**
     * Initializes a new instance of the LogIn class with the specified Authenticator and SMSCodeGenerator objects.
     *
     * @param auth an object implementing the Authenticator interface.
     * @param codeGenerator an object implementing the SMSCodeGenerator interface.
     */
    protected LogInAuthentication(Authenticator auth, SMSCodeGenerator codeGenerator){
        this.auth=auth;
        this.codeGenerator=codeGenerator;
    }

    protected LogInAuthentication(){
        this.auth=FactoryAuth.createAuthenticator();
        this.codeGenerator=FactoryAuth.createSMSCodeGenerator();
    }

    /**
     * Attempts to log in a user using authentication and SMS verification.
     *
     * @param username the username to authenticate.
     * @param password the password associated with the username.
     * @param phoneNumber the phone number associated with the user.
     * @param code the verification code to check against the generated code.
     * @throws LogInException if the Authentication login fails.
     *
     */
    protected boolean login(String username, String password, String phoneNumber, String code) throws LogInException{
        boolean authenticated = auth.authenticateLogIn(username, password);

        if (!authenticated) {
            throw new LogInException("Authentication login failed. " +
                    "Please check enter a valid username and password");
        }
        String generatedCode = codeGenerator.generateSMSCode(phoneNumber);
        if(!code.equals(generatedCode)){
            throw new LogInException("Code is invalid. " +
                    "The provided code does not match with the given code");
        }
        return (code.equals(generatedCode));

    }
}