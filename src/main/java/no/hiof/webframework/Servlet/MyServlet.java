package no.hiof.webframework.Servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        response.getWriter().println("Hello EveryBody!");
    }
}
