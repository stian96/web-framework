package Application;

import no.hiof.webframework.Application.Frontend.HtmlPageBuilder;
import org.eclipse.jetty.http.HttpMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HtmlPageBuilderTest {

    @Test
    void testThatAddMainSectionAddsMainSectionToThePage() {
        // setup
        HtmlPageBuilder builder = new HtmlPageBuilder();

        // act
        builder.addMainSection("Title", "a paragraph");
        String content = builder.build();

        // assert
        boolean titleFound = content.contains("<h1>Title</h1>");
        boolean paragraphFound = content.contains("<p>a paragraph</p>");

        Assertions.assertTrue(titleFound, "Title not found in the content");
        Assertions.assertTrue(paragraphFound, "Paragraph not found in the content");
    }

    @Test
    void testThatAddFromAddsFromToThePage() {

        // setup
        HtmlPageBuilder builder = new HtmlPageBuilder();

        // act
        builder.addForm(HttpMethod.POST, "username", "password");
        String content = builder.build();

        // assert
        boolean formMethodFound = content.contains("<form method='POST'>");
        boolean usernameFieldFound = content.contains("<input type='username' id='username' name='username' required>");

        Assertions.assertTrue(formMethodFound, "<form method='POST'>");
        Assertions.assertTrue(usernameFieldFound, "<input type='username' id='username' name='username' required>");

    }

    @Test
    void testThatAddFooterSectionAddsFooterToThePage() {

        // setup
        HtmlPageBuilder builder = new HtmlPageBuilder();

        // act
        builder.addFooterSection("example-address 2A", "95673425", "example@gmail.com");
        String content = builder.build();

        String contactInfo = "<footer>" +
                "<p>Address: " + "example-address 2A" + "</p>" +
                "<p>Phone: " + "95673425" + "</p>" +
                "<p>Email: " + "example@gmail.com" + "</p>" +
                "</footer>";

        // assert
        boolean footerFound  = content.contains(contactInfo);
        Assertions.assertTrue(footerFound, contactInfo);

    }
}
