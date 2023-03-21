package no.hiof.webframework.Security;

import no.hiof.webframework.Interface.Authenticator;
import no.hiof.webframework.Interface.SMSCodeGenerator;
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
    public LogInAuthentication(Authenticator auth, SMSCodeGenerator codeGenerator){
        this.auth=auth;
        this.codeGenerator=codeGenerator;
    }

    public LogInAuthentication(){
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
     * @return true if the user is successfully authenticated and verified, false otherwise.
     */
    public boolean login(String username, String password, String phoneNumber, String code) {
        boolean authenticated = auth.authenticateLogIn(username, password);

        if (!authenticated) {
            return false;
        }
        String generatedCode = codeGenerator.generateCode(phoneNumber);
        return (code.equals(generatedCode));

    }
}