package no.hiof.webframework.Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class ApplicationServlet extends HttpServlet {
    private static String applicationTitle = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body><h1>" + applicationTitle + "</h1></body></html>");
    }

    public static void setApplicationTitle(String title) {
        applicationTitle = title;
    }
}
