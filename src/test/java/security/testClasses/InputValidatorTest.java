package security.testClasses;

import no.hiof.webframework.security.UserInputValidatorForLoginForm;

public class InputValidatorTest extends UserInputValidatorForLoginForm {

 @Override
    public boolean validateUsername(String username){
     return super.validateUsername(username);
 }
 @Override
    public boolean validatePassword(String password){
     return super.validatePassword(password);
 }
}
