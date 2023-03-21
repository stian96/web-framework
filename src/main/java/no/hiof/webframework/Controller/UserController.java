package no.hiof.webframework.Controller;

import no.hiof.webframework.Data.User;
import no.hiof.webframework.Interface.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController {
    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDAO.get(username);

        if (user != null && user.getPassword().equals(password)) {
            response.sendRedirect("/home");
        }
        else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid username or password");
        }
    }
}

