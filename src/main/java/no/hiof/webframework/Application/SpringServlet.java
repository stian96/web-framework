package no.hiof.webframework.Application;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hiof.webframework.Application.Enums.ChatMethod;
import no.hiof.webframework.Application.Enums.Options;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

public class SpringServlet extends HttpServlet {

    protected static SpringServlet servlet;
    protected ChatMethod chatMethod = ChatMethod.GROUP;

    protected boolean timeStamp = false;

    protected String title;

    protected Options deleteButton;

    protected SpringServlet() {}

    protected static synchronized SpringServlet getServlet() {
        if (servlet == null) {
            servlet = new SpringServlet();
        }
        return servlet;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            jsonObject.put("chatMethod", this.chatMethod.ordinal());
            jsonObject.put("timeStamp", this.timeStamp);
            jsonObject.put("title", this.title);
            jsonObject.put("deleteButton", this.deleteButton.ordinal());
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
    }

    protected void setChatMethod(ChatMethod method) {
        this.chatMethod = method;
    }

    protected void setTimeStamp(boolean stamp) {this.timeStamp = stamp; }

    protected void setTitle(String title) { this.title = title; }

    protected void setDeleteButton(Options answer) {
        this.deleteButton = answer;
    }
}
