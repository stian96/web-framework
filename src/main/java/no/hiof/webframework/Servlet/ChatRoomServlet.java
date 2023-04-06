package no.hiof.webframework.Servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import no.hiof.webframework.Application.Chat.ChatRoom;
import no.hiof.webframework.Application.Chat.ChatUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;



public class ChatRoomServlet extends HttpServlet {

    private final InputStream pageContent;
    private final ChatRoom chatRoom;

    public ChatRoomServlet(ChatRoom chatRoom) {
        this.pageContent = getClass().getResourceAsStream("/Static/chatroom.html");
        this.chatRoom = chatRoom;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Hvis klienten ikke har spesifisert JSON, sender vi HTML-siden tilbake
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

        // Hent dataene fra AJAX-requesten
        String sender = request.getParameter("name");
        String message = request.getParameter("message");

        // Opprett chat brukere
        ChatUser stian = new ChatUser(sender);
        chatRoom.addUser(stian);

        chatRoom.sendMessage(stian, message);

        // Send respons til klienten i JSON-format
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("message", sender + ": " + message);

        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();

        // Send en bekreftelse tilbake til klienten
        response.setStatus(HttpServletResponse.SC_OK);
    }
}