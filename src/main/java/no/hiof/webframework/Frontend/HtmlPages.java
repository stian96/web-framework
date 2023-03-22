package no.hiof.webframework.Frontend;
import no.hiof.webframework.Interface.IHtmlPage;

import java.io.InputStream;

/**
 * This class contains pre-built HTML pages for a web application.
 * It implements the IHtmlPage interface.
 */
public class HtmlPages implements IHtmlPage {

    private InputStream htmlPage;
    private String title;

    /**
     * Constructs a new HtmlPages object.
     */
    public HtmlPages() {

    }

    /**
     * Returns an InputStream for the pre-built login page, which is fully designed and styled.
     * @return An InputStream of the login HTML page.
     */
    @Override
    public InputStream getLoginPage() {
        return getClass().getResourceAsStream("/Static/login.html");
    }

    /**
     * Returns an InputStream for the pre-built home page, which is fully designed and styled.
     * @return An InputStream of the home HTML page.
     */
    @Override
    public InputStream getHomePage() {
        return getClass().getResourceAsStream("/Static/home.html");
    }

    /**
     * Returns an InputStream for the pre-built logout page, which is fully designed and styled.
     * @return An InputStream of the logout HTML page.
     */
    @Override
    public InputStream getLogoutPage() {
        return getClass().getResourceAsStream("/Static/logout.html");
    }

    /**
     * Returns the HTML page as an InputStream.
     * @return The HTML page as an InputStream.
     */
    public InputStream getHtmlPage() {
        return htmlPage;
    }

    /**
     * Sets the HTML page as an InputStream.
     * @param htmlPage The HTML page as an InputStream.
     */
    public void setHtmlPage(InputStream htmlPage) {
        this.htmlPage = htmlPage;
    }

    /**
     * Returns the title of the HTML page.
     * @return The title of the HTML page.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the HTML page.
     * @param title The title of the HTML page.
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
