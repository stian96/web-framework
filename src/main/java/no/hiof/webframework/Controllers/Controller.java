package no.hiof.webframework.Controllers;

import no.hiof.webframework.Exceptions.HttpMethodException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Controller extends HttpServlet {

    private final String endpoint;

    public Controller(String endpoint) {
        this.endpoint = endpoint;
    }

    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, HttpMethodException {
        switch (request.getMethod()) {
            case "GET" -> handleGet(request, response);
            case "POST" -> handlePost(request, response);
            case "PUT" -> handlePut(request, response);
            default -> handleOther(request, response);
        }
    }

    abstract void handleGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, HttpMethodException;

    abstract void handlePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected void handlePut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}

    protected void handleOther(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}

    protected void render(String pageContent, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println(pageContent);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            handleRequest(request, response);
        } catch (Exception e) {
            throw new ServletException("Error in handling GET-request", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            handleRequest(request, response);
        } catch (Exception e) {
            throw new ServletException("Error in handling POST-request", e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            handleRequest(request, response);
        } catch (Exception e) {
            throw new ServletException("Error in handling PUT-request", e);
        }
    }

    protected void doOther(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

