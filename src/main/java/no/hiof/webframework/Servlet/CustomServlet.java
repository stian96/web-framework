package no.hiof.webframework.Servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomServlet extends HttpServlet {

    private final String pageContent;

    public CustomServlet(String pageContent) {
        this.pageContent = pageContent;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            response.getWriter().println(pageContent);
        }
        catch (IOException ioException) {
            System.out.println("Error: could not write the page content!\n" + ioException.getMessage());
        }
    }

}
