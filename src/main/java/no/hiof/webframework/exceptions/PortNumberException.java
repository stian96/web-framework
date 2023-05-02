package no.hiof.webframework.exceptions;

public class PortNumberException extends Exception {

    public PortNumberException() {
        super("Set port number on the server before calling the start server method!");
    }
}
