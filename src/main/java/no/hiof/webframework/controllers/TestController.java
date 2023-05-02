package no.hiof.webframework.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class TestController extends Controller {

    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1>Hello from TestController!</h1>");
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) {

    }

}
