package no.hiof.webframework.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The DefaultServlet class is a servlet that serves a simple plain text response.
 * It is typically used as a fallback servlet to handle requests that cannot be handled by other servlets.
 */
public class DefaultServlet extends HttpServlet {
    private final String content;

    /**
     * Constructs a new DefaultServlet with the specified page content.
     * @param pageContent the content of the page to be served by this servlet.
     */
    public DefaultServlet(String pageContent) {
        this.content = pageContent;
    }

    /**
     * Handles GET requests by writing the page content to the response in plain text format.
     * @param request the HTTP request object.
     * @param response the HTTP response object.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/plain");
            response.getWriter().println(content);
        }
        catch (IOException ioException) {
            System.out.println("Error: could not write the page content!\n" + ioException.getMessage());
        }
    }
}
