package no.hiof.webframework.Servlet.Default;
import no.hiof.webframework.Frontend.HtmlPages;
import no.hiof.webframework.Servlet.Default.AbstractServlet;

import java.io.InputStream;

public class LoginServlet extends AbstractServlet {

    public LoginServlet(HtmlPages page, String title) {
        super(page, title);
    }

    @Override
    protected InputStream getPageContent() {
        return getPage().getLoginPage();
    }
}