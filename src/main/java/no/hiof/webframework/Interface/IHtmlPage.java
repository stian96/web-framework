package no.hiof.webframework.Interface;

import java.io.InputStream;

/**
 * This is an interface for pre-built HTML pages. It defines methods to retrieve input streams for the login page,
 * home page, and logout page.
 */
public interface IHtmlPage {
    /**
     * Returns an input stream for the pre-built login page.
     * @return An input stream for the login page.
     */
    InputStream getLoginPage();

    /**
     * Returns an input stream for the pre-built home page.
     * @return An input stream for the home page.
     */
    InputStream getHomePage();

    /**
     * Returns an input stream for the pre-built logout page.
     * @return An input stream for the logout page.
     */
    InputStream getLogoutPage();
}
