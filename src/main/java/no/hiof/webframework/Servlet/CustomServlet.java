package no.hiof.webframework.Servlet;

import no.hiof.webframework.Data.User;
import no.hiof.webframework.Repository.UserDb;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomServlet extends HttpServlet {

    private final String pageContent;
    private UserDb userDb;

    public CustomServlet(String pageContent) {
        this.pageContent = pageContent;
    }

    public CustomServlet(String pageContent, UserDb user) {
        this.pageContent = pageContent;
        this.userDb = user;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        if (userDb.getDb().contains(user)) {
            response.getWriter().println("<h3>Login success!</h3>");
        }
        else {
            response.getWriter().println("<h3>User do not exists.</h3>");
        }
    }

}
