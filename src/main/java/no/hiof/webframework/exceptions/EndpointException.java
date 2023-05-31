package no.hiof.webframework.exceptions;

/**
 * Exception thrown when the server endpoint is not set before calling the start server method.
 */
public class EndpointException extends Exception {

    /**
     * Constructs a new EndpointException with a default error message.
     * The error message states that the server endpoint should be set before calling the start server method.
     */
    public EndpointException() {
        super("Set server endpoint before calling the start server method!");
    }
}
