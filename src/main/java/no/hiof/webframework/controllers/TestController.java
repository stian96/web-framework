package no.hiof.webframework.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class TestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h1>Hello from TestController!</h1>");
    }
}
