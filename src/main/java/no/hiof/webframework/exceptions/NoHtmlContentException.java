package no.hiof.webframework.exceptions;

public class NoHtmlContentException extends Exception {

    public NoHtmlContentException(String message) {
        super(message);
    }

    public NoHtmlContentException(String message, Throwable cause) {
        super(message, cause);
    }
}
