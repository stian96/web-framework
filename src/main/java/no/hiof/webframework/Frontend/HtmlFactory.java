package no.hiof.webframework.Frontend;

import no.hiof.webframework.Interface.AbstractHtmlFactory;

import java.io.InputStream;

public class HtmlFactory implements AbstractHtmlFactory<InputStream>
{

    @Override
    public InputStream createLoginPage() {
        return new HtmlPages().getLoginPage();
    }

    @Override
    public InputStream createHomePage() {
        return new HtmlPages().getHomePage();
    }

    @Override
    public InputStream createLogoutPage() {
        return new HtmlPages().getLogoutPage();
    }
}
