package no.hiof.webframework.Security;
//Scenario 3.5
import no.hiof.webframework.Interface.SMSCodeGenerator;
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
        // Generer og send kode via SMS
        return null;
    }
}
