package no.hiof.webframework.Interface.Builders;

/**
 * Abstract html-factory interface which can deliver
 * ready-made standard web-application pages.
 * @param <T> Generic parameter.
 */
public interface AbstractHtmlFactory<T> {
    T createLoginPage();
    T createHomePage();
    T createLogoutPage();
}
