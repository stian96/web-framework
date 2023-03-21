package no.hiof.webframework.Frontend;
import no.hiof.webframework.Interface.IHtmlPage;

import java.io.InputStream;

/**
 * Class that contains all the pre-built html pages.
 */
public class HtmlPages implements IHtmlPage {

    private InputStream htmlPage;
    private String title;


    public HtmlPages() {

    }

    /**
     * A pre-built login page which is fully designed and fully styled.
     * @return An InputStream of the Html page.
     */
    @Override
    public InputStream getLoginPage() {
        return getClass().getResourceAsStream("/Static/login.html");
    }

    /**
     * A pre-built home page which is fully designed and fully styled.
     * @return An InputStream of the Html page.
     */
    @Override
    public InputStream getHomePage() {
        return getClass().getResourceAsStream("/Static/home.html");
    }

    /**
     * A pre-built logout page which is fully designed and fully styled.
     * @return An InputStream of the Html page.
     */
    @Override
    public InputStream getLogoutPage() {
        return getClass().getResourceAsStream("/Static/logout.html");
    }

    public InputStream getHtmlPage() {
        return htmlPage;
    }

    public void setHtmlPage(InputStream htmlPage) {
        this.htmlPage = htmlPage;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
