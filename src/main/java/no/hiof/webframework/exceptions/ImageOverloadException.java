package no.hiof.webframework.exceptions;

/**
 * Exception thrown when an image overload occurs.
 */
public class ImageOverloadException extends Exception {

    /**
     * Constructs a new ImageOverloadException with the specified detail message.
     *
     * @param message the detail message
     */
    public ImageOverloadException(String message) {
        super(message);
    }
}
