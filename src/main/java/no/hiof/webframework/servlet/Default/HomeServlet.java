package no.hiof.webframework.servlet.Default;

import no.hiof.webframework.application.frontend.HtmlPages;

import java.io.InputStream;

/**
 * HomeServlet is a servlet that serves the homepage for a web application.
 * It extends the AbstractServlet class and implements the getPageContent method.
 */
public class HomeServlet extends AbstractServlet {
    /**
     * Constructor for creating a new instance of HomeServlet.
     * @param page the HtmlPages object representing the page content
     * @param title the title of the web application
     */
    public HomeServlet(HtmlPages page, String title) {
        super(page, title);
    }

    /**
     * Returns the InputStream representing the content of the homepage.
     * @return the InputStream representing the content of the homepage
     */
    @Override
    protected InputStream getPageContent() {
        return getPage().getHomePage();
    }
}
