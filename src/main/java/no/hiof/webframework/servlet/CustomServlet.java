package no.hiof.webframework.servlet;

import no.hiof.webframework.data.User;
import no.hiof.webframework.repository.UserDb;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CustomServlet is a class that extends HttpServlet and is used to handle GET and POST requests.
 * <p>
 * @author Stian Rusvik.
 */
public class CustomServlet extends HttpServlet {

    private final String pageContent;
    private UserDb userDb;

    /**
     * Constructor for CustomServlet class that takes a pageContent as a parameter.
     * @param pageContent the HTML content that will be sent to the client
     */
    public CustomServlet(String pageContent) {
        this.pageContent = pageContent;
    }

    /**
     * Constructor for CustomServlet class that takes a pageContent and a UserDb object as parameters.
     * @param pageContent the HTML content that will be sent to the client
     * @param user the UserDb object that will be used to check if a user exists in the database
     */
    public CustomServlet(String pageContent, UserDb user) {
        this.pageContent = pageContent;
        this.userDb = user;
    }

    /**
     * Overrides the doGet method of the HttpServlet class. It sends the pageContent to the client.
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     */
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

    /**
     * Overrides the doPost method of the HttpServlet class. It receives a username and password from the client and
     * checks if the user exists in the userDb. If the user exists, it redirects the client to "/home" and sends a success message.
     * If the user does not exist, it sends an error message to the client.
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new User(username, password);
            if (userDb.getDb().contains(user)) {
                response.sendRedirect("/home");
                response.getWriter().println("<h3>Login success!</h3>");
            }
            else {
                response.getWriter().println("<h3>User do not exists.</h3>");
            }
        }
        catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
