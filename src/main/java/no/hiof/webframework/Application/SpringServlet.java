package no.hiof.webframework.Application;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hiof.webframework.Application.Enums.ChatMethod;

import java.io.IOException;

public class SpringServlet extends HttpServlet {
    protected static SpringServlet servlet;
    protected ChatMethod chatMethod = ChatMethod.GROUP;

    protected SpringServlet() {}

    protected static synchronized SpringServlet getServlet() {
        if (servlet == null) {
            servlet = new SpringServlet();
        }
        return servlet;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(this.chatMethod.ordinal());
    }

    protected void setChatMethod(ChatMethod method) {
        this.chatMethod = method;
    }
}
