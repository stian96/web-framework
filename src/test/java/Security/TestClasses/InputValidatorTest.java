package Security.TestClasses;

import no.hiof.webframework.Security.UserInputValidator;

public class InputValidatorTest extends UserInputValidator {

 @Override
    public boolean validateUsername(String username){
     return super.validateUsername(username);
 }
 @Override
    public boolean validatePassword(String password){
     return super.validatePassword(password);
 }
}
