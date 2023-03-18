package no.hiof.webframework.Servlet;
import no.hiof.webframework.Enum.PageType;
import no.hiof.webframework.Frontend.HtmlPages;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ShowContent", urlPatterns = {"/login/*", "/home/*"})
public class ShowContent extends HttpServlet {
    private final String response;
    private final PageType pageType;

    public ShowContent(String response, PageType pageType) {
        this.response = response;
        this.pageType = pageType;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        HtmlPages htmlPages = new HtmlPages(pageType);

        String requestURI = request.getRequestURI();
        if (requestURI.startsWith("/login")) {
            writePage(htmlPages.getLoginPage(), response);
        } else if (requestURI.startsWith("/home")) {
            writePage(htmlPages.getHomePage(), response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void writePage(InputStream inputStream, HttpServletResponse response) throws IOException {
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