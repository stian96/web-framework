package no.hiof.webframework.Exceptions;

/**
 * Exception class thrown when login-method fails.
 * **/

public class LogInException extends Exception {
    /**
     * Creates a new LoginException with a given error message.
     * @param ExceptionMessageForLogIn The error message when login fails.
     */
    public LogInException(String ExceptionMessageForLogIn) {
        super(ExceptionMessageForLogIn);
    }
}