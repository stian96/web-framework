package Application;


import Application.TestClasses.InputValidatorTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TestInputValidator {
    @Test
    public void testValidUsername() {
        InputValidatorTest validUsrName = new InputValidatorTest();
        String username = "ThisIsMyUsername";
        assertTrue(validUsrName.validateUsername(username));
    }
    @Test
    public void testInvalidUsernameTooShort() {
        InputValidatorTest tooShortUsrName = new InputValidatorTest();
        String username = "hi";
        assertFalse(tooShortUsrName.validateUsername(username));
    }

    @Test
    public void testInvalidUsernameTooLong() {
        InputValidatorTest tooLongUsrName = new InputValidatorTest();
        String username = "MyUsernameIsTooLongToUse";
        assertFalse(tooLongUsrName.validateUsername(username));
    }

    @Test
    public void testValidPassword() {
        InputValidatorTest validPassword = new InputValidatorTest();
        String password = "myPW321isValid";
        assertTrue(validPassword.validatePassword(password));
    }
    @Test
    public void testInvalidPasswordTooShort() {
        InputValidatorTest toShortPw = new InputValidatorTest();
        String password = "hi43";
        assertFalse(toShortPw.validatePassword(password));
    }
    @Test
    public void testInvalidPasswordTooLong() {
        InputValidatorTest toLongPw = new InputValidatorTest();
        String password = "myPasswordsIsTooLong78987667";
        assertFalse(toLongPw.validatePassword(password));
    }

    @Test
    public void testInvalidPasswordNoAlphabets() {
        InputValidatorTest containsNoAlphabets = new InputValidatorTest();
        String password = "4848489990";
        assertFalse(containsNoAlphabets.validatePassword(password));
    }
    @Test
    public void testInvalidPasswordNoNumbers() {
        InputValidatorTest containsNoNumbers = new InputValidatorTest();
        String password = "PwIsOnlyLetters";
        assertFalse(containsNoNumbers.validatePassword(password));
    }
    @Test
    public void testInvalidPasswordNotAlphanumericOnly() {
        InputValidatorTest containsNonAlphanumeric = new InputValidatorTest();
        String password = "Not-Alphanumeric";
        assertFalse(containsNonAlphanumeric.validatePassword(password));
    }

}
