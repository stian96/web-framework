package no.hiof.webframework.servlet.defaultServlets;

import no.hiof.webframework.application.frontend.HtmlPages;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * The AbstractServlet class is an abstract class that extends the HttpServlet class
 * and provides common functionality for servlets that generate HTML pages.
 * <p>
 * @author Stian Rusvik.
 */
abstract class AbstractServlet extends HttpServlet {
    private HtmlPages page;
    private String title;

    /**
     * Constructs a new AbstractServlet object with the given page and title.
     * @param page The HtmlPages object representing the page to be displayed.
     * @param title The title of the page.
     */
    public AbstractServlet(HtmlPages page, String title) {
        this.page = page;
        this.title = title;
    }

    /**
     * Constructs a new AbstractServlet object.
     */
    public AbstractServlet() {
    }

    /**
     * Handles HTTP GET requests by setting the content type to text/html, setting the response status to OK,
     * and writing the page content to the response output stream.
     * @param request The HttpServletRequest object representing the client's request.
     * @param response The HttpServletResponse object representing the server's response.
     * @throws IOException If an I/O error occurs while handling the request.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        PageWriter.writePage(getPageContent(), response, title);
    }

    /**
     * Returns an InputStream object representing the page content.
     * @return An InputStream object representing the page content.
     */
    protected abstract InputStream getPageContent();

    /**
     * Returns the HtmlPages object representing the page to be displayed.
     * @return The HtmlPages object representing the page to be displayed.
     */
    public HtmlPages getPage() {
        return page;
    }

    /**
     * Sets the HtmlPages object representing the page to be displayed.
     * @param page The HtmlPages object representing the page to be displayed.
     */
    public void setPage(HtmlPages page) {
        this.page = page;
    }

    /**
     * Returns the title of the page.
     * @return The title of the page.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the page.
     * @param title The title of the page.
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
