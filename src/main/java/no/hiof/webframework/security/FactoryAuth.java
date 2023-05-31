package no.hiof.webframework.security;

import no.hiof.webframework.interfaces.Authenticator;
import no.hiof.webframework.interfaces.SMSCodeGenerator;

/**
 * The FactoryAuth class provides a factory method for creating Authenticator and SMSCodeGenerator objects
 * */
public class FactoryAuth {
    /**
     * Creates an object that implements Authenticator interface.
     * @return  an object that implements the Authenticator interface*/
    protected static Authenticator createAuthenticator(){
        return new Authentication();
    }

    /**
     * Creates an object that implements the SMSCodeGenerator interface.
     * @return an object that implements the SMSCodeGenerator interface.*/
    protected static SMSCodeGenerator createSMSCodeGenerator(){
        return new SMSVerification();
    }


}
