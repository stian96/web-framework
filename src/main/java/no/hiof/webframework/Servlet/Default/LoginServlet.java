package no.hiof.webframework.Servlet.Default;
import no.hiof.webframework.Frontend.HtmlPages;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class LoginServlet extends AbstractServlet {

    public LoginServlet(HtmlPages page, String title) {
        super(page, title);
    }

    public LoginServlet() {}

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

    @Override
    protected InputStream getPageContent() {
        return getPage().getLoginPage();
    }
}