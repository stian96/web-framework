package no.hiof.webframework.Controllers;

import no.hiof.webframework.Exceptions.HttpMethodException;
import no.hiof.webframework.Frontend.HtmlPageBuilder;
import org.eclipse.jetty.http.HttpMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyController extends Controller {

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, HttpMethodException {

        HtmlPageBuilder builder = new HtmlPageBuilder();
        builder.addHeader("Controller test");
        builder.addForm(HttpMethod.POST, "username", "password");

        render(builder.build(), request, response);
    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("stian") && password.equals("hello123"))
            response.getWriter().println("<h3>Login success!</h3>");
        else
            response.getWriter().println("<h3>User do not exists.</h3>");

    }
}

