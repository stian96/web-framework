package no.hiof.webframework.Servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefaultServlet extends HttpServlet {
    private final String content;

    public DefaultServlet(String pageContent) {
        this.content = pageContent;
    }


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
