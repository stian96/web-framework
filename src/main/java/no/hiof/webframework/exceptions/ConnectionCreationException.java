package no.hiof.webframework.exceptions;

/**
 * Exception thrown when an error occurs during connection creation.
 */
public class ConnectionCreationException extends RuntimeException {

    /**
     * Constructs a new ConnectionCreationException with the specified error message.
     *
     * @param message the error message
     */
    public ConnectionCreationException(String message) {
        super(message);
    }

    /**
     * Constructs a new ConnectionCreationException with the specified error message and cause.
     *
     * @param message the error message
     * @param cause the cause of the exception
     */
    public ConnectionCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
