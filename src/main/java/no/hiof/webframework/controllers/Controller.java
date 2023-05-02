package no.hiof.webframework.controllers;

import no.hiof.webframework.exceptions.HttpMethodException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Abstract class representing a controller in the MVC-pattern for web applications. Extends the HttpServlet class
 * to handle HTTP requests. It provides methods for handling GET, POST, PUT and other HTTP requests, as well as rendering
 * HTML pages. The class also contains a switch statement that determines how to handle the request based on its HTTP method.
 * The endpoint is a String that represents the URL path for the controller.
 */
public abstract class Controller extends HttpServlet {

    private String endpoint = null;

    /**
     * Constructor for the Controller class.
     * @param endpoint a String representing the URL path for the controller
     */
    public Controller(String endpoint) {
        this.endpoint = endpoint;
    }

    public Controller() {

    }

    /**
     * Method for handling an HTTP request. Determines how to handle the request based on its HTTP method.
     * Calls the appropriate method for handling the request.
     * @param request an HttpServletRequest object representing the request
     * @param response an HttpServletResponse object representing the response
     * @throws ServletException if an error occurs while processing the request
     * @throws IOException if an error occurs while processing the request or response
     * @throws HttpMethodException if an unsupported HTTP method is used
     */
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, HttpMethodException {
        switch (request.getMethod()) {
            case "GET" -> handleGet(request, response);
            case "POST" -> handlePost(request, response);
            case "PUT" -> handlePut(request, response);
            default -> handleOther(request, response);
        }
    }

    /**
     * Abstract method for handling GET-requests. Subclasses must provide an implementation for this method.
     * @param request an HttpServletRequest object representing the request
     * @param response an HttpServletResponse object representing the response
     * @throws ServletException if an error occurs while processing the request
     * @throws IOException if an error occurs while processing the request or response
     * @throws HttpMethodException if an unsupported HTTP method is used
     */
    public abstract void handleGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, HttpMethodException;

    /**
     * Abstract method for handling POST-requests. Subclasses must provide an implementation for this method.
     * @param request an HttpServletRequest object representing the request
     * @param response an HttpServletResponse object representing the response
     * @throws ServletException if an error occurs while processing the request
     * @throws IOException if an error occurs while processing the request or response
     */
    public abstract void handlePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    /**
     * Empty method for handling PUT-requests. Can be overridden if needed.
     */
    protected void handlePut(HttpServletRequest request, HttpServletResponse response) {}

    /**
     * Empty method for handling other HTTP requests. Can be overridden if needed.
     */
    protected void handleOther(HttpServletRequest request, HttpServletResponse response) {}

    /**
     * Renders the specified HTML content to the response.
     * Sets the response content type to "text/html".
     * @param pageContent The HTML content to render.
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws IOException if there is an I/O exception.
     */
    protected void render(String pageContent, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println(pageContent);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            handleRequest(request, response);
        } catch (Exception e) {
            throw new ServletException("Error in handling GET-request", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            handleRequest(request, response);
        } catch (Exception e) {
            throw new ServletException("Error in handling POST-request", e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            handleRequest(request, response);
        } catch (Exception e) {
            throw new ServletException("Error in handling PUT-request", e);
        }
    }

    protected void doOther(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            handleRequest(request, response);
        } catch (Exception e) {
            throw new ServletException("Error in handling other requests", e);
        }
    }

    public String getEndpoint() {
        return endpoint;
    }
}

