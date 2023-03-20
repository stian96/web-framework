package no.hiof.webframework.Frontend;
import no.hiof.webframework.Interface.Builders.AbstractHtmlFactory;
import java.io.InputStream;

public class HtmlFactory implements AbstractHtmlFactory<InputStream>
{
    private final HtmlPages pages = new HtmlPages();

    @Override
    public InputStream createLoginPage() {
        return pages.getLoginPage();
    }

    @Override
    public InputStream createHomePage() {
        return pages.getHomePage();
    }

    @Override
    public InputStream createLogoutPage() {
        return pages.getLogoutPage();
    }
}
