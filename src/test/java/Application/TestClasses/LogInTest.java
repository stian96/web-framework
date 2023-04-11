package Application.TestClasses;

import no.hiof.webframework.Interface.Authenticator;
import no.hiof.webframework.Interface.SMSCodeGenerator;
import no.hiof.webframework.Security.LogInAuthentication;

public class LogInTest extends LogInAuthentication {
    public LogInTest(Authenticator auth, SMSCodeGenerator codeGenerator) {
        super(auth, codeGenerator);
    }

    @Override
    public boolean login(String username, String password, String phoneNumber, String code){
        return super.login(username,password,phoneNumber,code);

    }

}
