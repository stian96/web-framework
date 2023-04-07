package Application;

import Application.TestClasses.LogInTest;
import no.hiof.webframework.Interface.SMSCodeGenerator;
import no.hiof.webframework.Security.Authentication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class MockLoginTest {
    @Test
    public void testSuccessfulLogIn () {

        // et mock autentiserings-objekt
        Authentication mockAuth = new Authentication() {
            public boolean authenticateLogIn(String username, String password) {
                return true;
            }
        };

        //  et mock kode-generator-objekt
        SMSCodeGenerator mockCode = new SMSCodeGenerator() {
            public String generateSMSCode(String phoneNumber) {
                return "98647777";
            }
        };

        // Et login objekt med lagde mock-objekter.
        LogInTest testUser = new LogInTest(mockAuth, mockCode);

        // Vellykket innlogging
        assertTrue(testUser.login("myUsrName", "22MyPw4455",
                "+4791245677", "98647777"));
    }

    @Test
    public void testAuthenticationFailLogIn () {

        // et mock autentiserings-objekt
        Authentication mockAuth = new Authentication() {
            public boolean authenticateLogIn(String username, String password) {
                return username.equals("myUsrName") & password.equals("22MyPw4455");
            }
        };

        //  et mock kode-generator-objekt
        SMSCodeGenerator mockCode = new SMSCodeGenerator() {
            public String generateSMSCode(String phoneNumber) {
                return "98647777";
            }
        };

        // Et login objekt med lagde mock-objekter.
        LogInTest testUser = new LogInTest(mockAuth, mockCode);

        // autentiseringsfeil
        assertFalse(testUser.login("wrongUsername", "wrongPassword",
                "+4791245677", "98647777"));
    }

    @Test
    public void testIncorrectSMSCodeLogIn () {

        // et mock autentiserings-objekt
        Authentication mockAuth = new Authentication() {
            public boolean authenticateLogIn(String username, String password) {
                return true;
            }
        };

        //  et mock kode-generator-objekt
        SMSCodeGenerator mockCode = new SMSCodeGenerator() {
            public String generateSMSCode(String phoneNumber) {
                return "98647777";
            }
        };

        // Et login objekt med lagde mock-objekter.
        LogInTest testUser = new LogInTest(mockAuth, mockCode);

        // Feil SMS code
        assertFalse(testUser.login("myUsrName", "22MyPw4455",
                "+4791245677", "08767876"));
    }
}
