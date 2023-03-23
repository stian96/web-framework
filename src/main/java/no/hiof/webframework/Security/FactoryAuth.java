package no.hiof.webframework.Security;
//Scenario 3.5
import no.hiof.webframework.Interface.Authenticator;
import no.hiof.webframework.Interface.SMSCodeGenerator;

/**
 * The FactoryAuth class provides a factory method for creating Authenticator and SMSCodeGenerator objects
 * */
public class FactoryAuth {
    /**
     * Creates an object that implements Authenticator interface.
     * @return  an object that implements the Authenticator interface*/
    public static Authenticator createAuthenticator(){
        //Returnerer en implementasjon av Authenticator interfacet basert på gitte kriterier.
        return new Authentication();
    }

    /**
     * Creates an object that implements the SMSCodeGenerator interface.
     * @return an object that implements the SMSCodeGenerator interface.*/
    public static SMSCodeGenerator createSMSCodeGenerator(){
        //Returnerer en implementasjon av SMSCodeGenerator interfacet basert på gitte kriterier.
        return new SMSVerification();
    }


}
