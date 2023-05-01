package no.hiof.webframework.Servlet.Default;

import no.hiof.webframework.application.Frontend.HtmlPages;

import java.io.InputStream;

/**
 * A servlet class that handles the logout functionality of the web application.
 * Extends the AbstractServlet class and implements the getPageContent method to
 * retrieve the content of the logout page.
 */
public class LogoutServlet extends AbstractServlet {
    /**
     * Constructs a LogoutServlet object with the specified HTML page and title.
     * @param page the HTML page that contains the logout content
     * @param title the title of the logout page
     */
    public LogoutServlet(HtmlPages page, String title) {
        super(page, title);
    }

    /**
     * Retrieves the content of the logout page.
     * @return an InputStream containing the content of the logout page
     */
    @Override
    protected InputStream getPageContent() {
        return getPage().getLogoutPage();
    }
}
