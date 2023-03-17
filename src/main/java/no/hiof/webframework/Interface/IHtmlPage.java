package no.hiof.webframework.Interface;


import no.hiof.webframework.Enum.PageType;

import java.io.InputStream;

public interface IHtmlPage {
    InputStream getLoginPage();
    InputStream getHomePage();
    InputStream getLogoutPage();

    PageType getPageType();
}
