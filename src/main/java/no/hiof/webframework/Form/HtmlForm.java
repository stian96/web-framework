package no.hiof.webframework.Form;

import no.hiof.webframework.Interface.IHtmlForm;

import java.io.InputStream;

public class HtmlForm implements IHtmlForm {
    public HtmlForm() {

    }
    @Override
    public InputStream getLoginForm() {
        return getClass().getResourceAsStream("/login.html");
    }
}
