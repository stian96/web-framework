package no.hiof.webframework.application.frontend;

import no.hiof.webframework.Interface.Builders.AbstractHtmlFactory;
import java.io.InputStream;

/**
 * The HtmlFactory class implements the AbstractHtmlFactory interface to provide
 * methods for creating different types of HTML pages. It uses an instance of the
 * HtmlPages class to generate the pages.
 */
public class HtmlFactory implements AbstractHtmlFactory<InputStream>
{
    private final HtmlPages pages = new HtmlPages();

    /**
     * Creates a login page.
     * @return an input stream containing the login page HTML code
     */
    @Override
    public InputStream createLoginPage() {
        return pages.getLoginPage();
    }

    /**
     * Creates a home page.
     * @return an input stream containing the home page HTML code
     */
    @Override
    public InputStream createHomePage() {
        return pages.getHomePage();
    }

    /**
     * Creates a logout page.
     * @return an input stream containing the logout page HTML code
     */
    @Override
    public InputStream createLogoutPage() {
        return pages.getLogoutPage();
    }
}
