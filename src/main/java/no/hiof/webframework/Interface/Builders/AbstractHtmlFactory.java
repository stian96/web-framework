package no.hiof.webframework.Interface.Builders;

/**
 * This is an abstract interface for an HTML factory which creates pre-built standard web application pages.
 * It defines three methods to create a login page, home page, and logout page.
 * @param <T> The generic type of the pages that are created.
 */
public interface AbstractHtmlFactory<T> {
    /**
     * Creates a pre-built login page which is fully designed and styled.
     * @return The pre-built login page as an object of type T.
     */
    T createLoginPage();

    /**
     * Creates a pre-built home page which is fully designed and styled.
     * @return The pre-built home page as an object of type T.
     */
    T createHomePage();

    /**
     * Creates a pre-built logout page which is fully designed and styled.
     * @return The pre-built logout page as an object of type T.
     */
    T createLogoutPage();
}
