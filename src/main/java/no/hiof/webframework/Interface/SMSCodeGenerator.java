package no.hiof.webframework.Interface;
/**
 * The SMSCodeGenerator interface provides a contract for classes that generate and send verification codes via SMS.
 */
public interface SMSCodeGenerator {
    String generateCode(String phoneNumber);

}
