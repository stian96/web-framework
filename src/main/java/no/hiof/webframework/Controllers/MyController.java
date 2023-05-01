package no.hiof.webframework.Controllers;

import no.hiof.webframework.Exceptions.HttpMethodException;
import no.hiof.webframework.application.Frontend.HtmlPageBuilder;
import org.eclipse.jetty.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Just an example class to demonstrate a scenario, (not a part of the API).
 */
public class MyController extends Controller {

    public MyController(String endpoint) {
        super(endpoint);
    }

    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException, HttpMethodException {

        HtmlPageBuilder builder = new HtmlPageBuilder();
        builder.addHeader("Controller test");
        builder.addForm(HttpMethod.POST, "username", "password");

        render(builder.build(), request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("stian") && password.equals("hello123"))
            response.getWriter().println("<h3>Login success!</h3>");
        else
            response.getWriter().println("<h3>User do not exists.</h3>");

    }
}

