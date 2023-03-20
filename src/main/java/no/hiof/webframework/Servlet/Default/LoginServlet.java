package no.hiof.webframework.Servlet.Default;
import no.hiof.webframework.Frontend.HtmlPages;
import no.hiof.webframework.Servlet.Default.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class LoginServlet extends AbstractServlet {

    public LoginServlet(HtmlPages page, String title) {
        super(page, title);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

    }

    @Override
    protected InputStream getPageContent() {
        return getPage().getLoginPage();
    }
}