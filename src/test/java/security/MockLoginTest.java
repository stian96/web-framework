package security;

import security.TestClasses.LogInTest;
import no.hiof.webframework.exceptions.LogInException;
import no.hiof.webframework.interfaces.SMSCodeGenerator;
import no.hiof.webframework.security.Authentication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class MockLoginTest {
    @Test
    public void testSuccessfulLogIn () throws LogInException {

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
    public void testAuthenticationFailLogIn () throws LogInException {


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

            // autentiseringsfeil, samt sjekker at riktig feilmelding blir gitt.
        try { testUser.login("wrongUsername", "wrongPassword",
                    "+4791245677", "98647777");
            fail("Expected LogInException was not thrown");
        } catch(LogInException exMessage){
            assertEquals("Authentication login failed. Please check enter a valid username and password"
                    , exMessage.getMessage());
        }
    }

    @Test
    public void testIncorrectSMSCodeLogIn () throws LogInException {

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

        // Feil SMS code, samt sjekker at riktig feilmelding blir gitt.
        try {
            testUser.login("myUsrName", "22MyPw4455",
                    "+4791245677", "08767876");
            fail("Expected LogInException was not thrown");
        } catch (LogInException exMessage){
            assertEquals("Code is invalid. The provided code does not match with the given code",
                    exMessage.getMessage());
        }

    }
}
