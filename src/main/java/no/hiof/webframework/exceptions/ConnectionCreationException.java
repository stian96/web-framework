package no.hiof.webframework.exceptions;

public class ConnectionCreationException extends RuntimeException {
    public ConnectionCreationException(String message) {
        super(message);
    }

    public ConnectionCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
