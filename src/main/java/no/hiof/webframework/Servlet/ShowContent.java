package no.hiof.webframework.Servlet;
import no.hiof.webframework.Form.HtmlForm;
import no.hiof.webframework.Interface.IHtmlForm;

import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowContent extends HttpServlet {
    private final String response;
    private HtmlForm htmlForm;

    public ShowContent(String response) {
        this.response = response;
    }

    public ShowContent(String response, IHtmlForm form) {
        this.response = response;
        this.htmlForm = (HtmlForm) form;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        if (htmlForm != null) {
            writeForm(htmlForm.getLoginForm(), response);
        }
        else {
            PrintWriter writer = response.getWriter();
            writer.println("<h1>" + this.response + "</h1>");
        }
    }

    private void writeForm(InputStream inputStream, HttpServletResponse response) throws IOException {
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = response.getWriter();
            writer.println("<h1>" + this.response + "</h1>");

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        }
    }
}