package security;

import no.hiof.webframework.security.SMSVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class smsVerificationTest  {
    @Test
    public void testSmsCodeNotNull(){
        SMSVerification verification =  new SMSVerification();
        String tlfNr= "+4791245677";
        String sentCode = verification.generateSMSCode(tlfNr);

        //Sjekker at koden ikke er null
        Assertions.assertNotNull(sentCode);
    }
    @Test
    public void testValidLengthForSmsCode(){
        SMSVerification verification =  new SMSVerification();
        String tlfNr= "+4791245677";
        String sentCode = verification.generateSMSCode(tlfNr);

        //Sjekker at koden er lik 8-siffret
        Assertions.assertEquals(8, sentCode.length());
    }
    @Test
    public void testSmsCodeIsNumeric(){
        SMSVerification verification =  new SMSVerification();
        String tlfNr= "+4791245677";
        String sentCode = verification.generateSMSCode(tlfNr);

        //Sjekker at koden inneholder numeriske tegn
        Assertions.assertTrue(sentCode.matches("\\d+"));
    }
}
