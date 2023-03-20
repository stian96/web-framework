package no.hiof.webframework.Interface;

import java.io.InputStream;

public interface IHtmlPage {
    InputStream getLoginPage();
    InputStream getHomePage();
    InputStream getLogoutPage();
}
