package no.hiof.webframework.security;
//Scenario 3.5
import no.hiof.webframework.interfaces.SMSCodeGenerator;

import java.util.Random;

/**
 * The SMS class generates and sends verification codes via SMS.
 */
public class SMSVerification implements SMSCodeGenerator {

    /**
     * Generates a verification code and sends it to a given phone number.
     *
     * @param phoneNumber the phone number to send the verification code to.
     * @return the generated verification code.
     */
    @Override
    public String generateSMSCode(String phoneNumber) {
        Random randomCode = new Random();
        int smsCode= 10000000 + randomCode.nextInt(90000000);
        return String.valueOf(smsCode);
    }

}
