package no.hiof.webframework.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class ChatRoomServlet extends HttpServlet {

    private final InputStream pageContent;

    public ChatRoomServlet() {
        this.pageContent = getClass().getResourceAsStream("/Static/chatroom.html");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_OK);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(pageContent))) {
            PrintWriter writer = response.getWriter();

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}