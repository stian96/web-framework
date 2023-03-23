package no.hiof.webframework.Servlet.Default;
import no.hiof.webframework.Application.Frontend.HtmlPages;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * The LoginServlet class is a subclass of the AbstractServlet class,representing the login page of a web application.
 * It allows users to log in by entering their username and password.
 */
public class LoginServlet extends AbstractServlet {
    /**
     * Constructs a LoginServlet object with the specified HtmlPages and title.
     * @param page an instance of HtmlPages that contains information about the login page.
     * @param title the title of the login page.
     */
    public LoginServlet(HtmlPages page, String title) {
        super(page, title);
    }

    /**
     * Constructs a LoginServlet object.
     */
    public LoginServlet() {}

    /**
     * Handles POST requests sent to the login page.
     * Validates the user's credentials by checking them against a database.
     * If the user exists in the database, redirects them to the home page.
     * If not, redirects them back to the login page.
     * @param request the HttpServletRequest object containing the request made to the servlet
     * @param response the HttpServletResponse object containing the response that will be sent back to the client
     * @throws IOException if an input or output exception occurred while handling the request
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Here we will test with the database later.
        if (username.equals("Stian") && password.equals("Hello123")) {
            System.out.println("Login success!");
            response.sendRedirect("http://localhost:8080/home");
        }
        else {
            System.out.println("The user does not exist in the database");
            response.sendRedirect("http://localhost:8080/login");
        }
    }

    /**
     * Returns the InputStream of the login page content.
     * @return the InputStream of the login page content
     */
    @Override
    protected InputStream getPageContent() {
        return getPage().getLoginPage();
    }
}