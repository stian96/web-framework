package no.hiof.webframework.exceptions;

/**
 * A custom exception class for chat method-related exceptions.
 */
public class ChatMethodException extends Exception {

    /**
     * Constructs a new ChatMethodException with the specified error message.
     *
     * @param message the error message
     */
    public ChatMethodException(String message) {
        super(message);
    }
}
