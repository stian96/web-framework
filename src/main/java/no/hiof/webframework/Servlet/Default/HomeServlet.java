package no.hiof.webframework.Servlet.Default;

import no.hiof.webframework.Frontend.HtmlPages;

import java.io.InputStream;

public class HomeServlet extends AbstractServlet {
    public HomeServlet(HtmlPages page, String title) {
        super(page, title);
    }

    @Override
    protected InputStream getPageContent() {
        return getPage().getHomePage();
    }
}
