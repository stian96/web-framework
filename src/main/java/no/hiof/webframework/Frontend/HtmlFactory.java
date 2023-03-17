package no.hiof.webframework.Frontend;

import no.hiof.webframework.Interface.AbstractHtmlFactory;

import java.io.InputStream;

import static no.hiof.webframework.Enum.PageType.*;

public class HtmlFactory implements AbstractHtmlFactory<InputStream>
{

    @Override
    public InputStream createLoginPage() {
        return new HtmlPages(LOGIN).getLoginPage();
    }

    @Override
    public InputStream createHomePage() {
        return new HtmlPages(HOME).getHomePage();
    }

    @Override
    public InputStream createLogoutPage() {
        return new HtmlPages(LOGOUT).getLogoutPage();
    }
}
