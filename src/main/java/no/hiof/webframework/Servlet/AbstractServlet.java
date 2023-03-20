package no.hiof.webframework.Servlet;

import no.hiof.webframework.Frontend.HtmlPages;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

abstract class AbstractServlet extends HttpServlet {
    private HtmlPages page;
    private String title;

    public AbstractServlet(HtmlPages page, String title) {
        this.page = page;
        this.title = title;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        PageWriter.writePage(getPageContent(), response, title);
    }

    protected abstract InputStream getPageContent();

    public HtmlPages getPage() {
        return page;
    }

    public void setPage(HtmlPages page) {
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
