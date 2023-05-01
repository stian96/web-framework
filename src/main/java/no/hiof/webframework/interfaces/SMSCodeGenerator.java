package no.hiof.webframework.interfaces;
//Scenario 3.5
/**
 * The SMSCodeGenerator interface provides a contract for classes that generate and send verification codes via SMS.
 */
public interface SMSCodeGenerator {
    String generateSMSCode(String phoneNumber);

}
