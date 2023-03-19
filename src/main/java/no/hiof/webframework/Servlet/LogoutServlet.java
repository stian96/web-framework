package no.hiof.webframework.Servlet;

import no.hiof.webframework.Frontend.HtmlPages;

import java.io.InputStream;

public class LogoutServlet extends AbstractServlet {

    public LogoutServlet(HtmlPages page, String title) {
        super(page, title);
    }

    @Override
    protected InputStream getPageContent() {
        return getPage().getLogoutPage();
    }
}
