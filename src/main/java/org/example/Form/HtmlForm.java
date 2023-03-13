package org.example.Form;

import org.example.Interface.IHtmlForm;

import java.io.InputStream;

public class HtmlForm implements IHtmlForm {
    public HtmlForm() {

    }
    @Override
    public InputStream getLoginForm() {
        return getClass().getResourceAsStream("/static/login.html");
    }
}
