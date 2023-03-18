package no.hiof.webframework.Exceptions;

public class NoHtmlContentException extends RuntimeException {

    public NoHtmlContentException() {}

    public NoHtmlContentException(String message) {
        super(message);
    }

    public NoHtmlContentException(String message, Throwable cause) {
        super(message, cause);
    }
}
