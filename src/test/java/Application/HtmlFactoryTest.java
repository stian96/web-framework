package Application;

import no.hiof.webframework.application.frontend.HtmlFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class HtmlFactoryTest {

    @Test
    void testThatHtmlFactoryReturnsLoginPage() {

        // Setup
        HtmlFactory factory = new HtmlFactory();

        // act
        InputStream loginPageStream = factory.createLoginPage();

        // Assert
        Assertions.assertNotNull(loginPageStream);
        Assertions.assertInstanceOf(InputStream.class, loginPageStream);
    }

    @Test
    void testThatHtmlFactoryReturnsHomePage() {

        // Setup
        HtmlFactory factory = new HtmlFactory();

        // act
        InputStream homePageStream = factory.createHomePage();

        // Assert
        Assertions.assertNotNull(homePageStream);
        Assertions.assertInstanceOf(InputStream.class, homePageStream);
    }

    @Test
    void testThatHtmlFactoryReturnsLogoutPage() {

        // Setup
        HtmlFactory factory = new HtmlFactory();

        // act
        InputStream logoutPageStream = factory.createLogoutPage();

        // Assert
        Assertions.assertNotNull(logoutPageStream);
        Assertions.assertInstanceOf(InputStream.class, logoutPageStream);
    }
}
