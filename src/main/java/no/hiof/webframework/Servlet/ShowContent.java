package no.hiof.webframework.Servlet;
import no.hiof.webframework.Interface.IHtmlPage;

import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowContent extends HttpServlet {
    private final String response;
    private final IHtmlPage htmlPage;

    public ShowContent(String response, IHtmlPage page) {
        this.response = response;
        this.htmlPage = page;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        if (htmlPage != null) {
            writeForm(htmlPage.getLoginPage(), response);
        }
    }

    private void writeForm(InputStream inputStream, HttpServletResponse response) throws IOException {
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = response.getWriter();
            writer.println("<h1 style='text-align: center; color: slategray;'>" + this.response + "</h1>");

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        }
    }
}