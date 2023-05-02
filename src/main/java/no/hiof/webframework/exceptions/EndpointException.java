package no.hiof.webframework.exceptions;

public class EndpointException extends Exception {

    public EndpointException()
    {
        super("Set server endpoint before calling the start server method!");
    }
}
