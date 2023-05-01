package no.hiof.webframework.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The ApplicationServlet class is a servlet that sets the application title
 * and responds to GET requests with an HTML page
 */
@WebServlet("/")
public class ApplicationServlet extends HttpServlet {
    private static String applicationTitle = "";

    /**
     * Responds to GET requests with an HTML page containing the application title.
     * @param request the HttpServletRequest object that contains the client's request
     * @param response the HttpServletResponse object that contains the servlet's response
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/html");
            response.getWriter().println("<html><body><h1>" + applicationTitle + "</h1></body></html>");
        }
        catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    /**
     * Sets the application title.
     * @param title the title to set
     */
    public static void setApplicationTitle(String title) {
        applicationTitle = title;
    }
}
