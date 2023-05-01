package security.testClasses;

import no.hiof.webframework.exceptions.LogInException;
import no.hiof.webframework.interfaces.Authenticator;
import no.hiof.webframework.interfaces.SMSCodeGenerator;
import no.hiof.webframework.security.LogInAuthentication;

public class LogInTest extends LogInAuthentication {
    public LogInTest(Authenticator auth, SMSCodeGenerator codeGenerator) {
        super(auth, codeGenerator);
    }

    @Override
    public boolean login(String username, String password, String phoneNumber, String code) throws LogInException {
        return super.login(username,password,phoneNumber,code);

    }

}
