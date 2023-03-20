package no.hiof.webframework.Security;

import no.hiof.webframework.Interface.SMSCodeGenerator;
/**
 * The SMS class generates and sends verification codes via SMS.
 */
public class SMS implements SMSCodeGenerator {
    /**
     * Generates a verification code and sends it to a given phone number.
     *
     * @param phoneNumber the phone number to send the verification code to.
     * @return the generated verification code.
     */
    @Override
    public String generateCode(String phoneNumber) {
        // Generer og send kode via SMS
        return null;
    }
}
