package no.hiof.webframework;

import no.hiof.webframework.Application.App;
import no.hiof.webframework.Frontend.HtmlFactory;
import no.hiof.webframework.Frontend.HtmlPageBuilder;
import org.eclipse.jetty.http.HttpMethod;



public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.setTitle("My Application");

        app.addRoute("login", HttpMethod.GET);
        app.addRoute("home", HttpMethod.GET);
        app.addRoute("custom", HttpMethod.GET);

        HtmlFactory factory = new HtmlFactory();

        app.addHtmlPage(factory.createLoginPage());
        app.setLoginPageTitle("Login");

        app.addHtmlPage(factory.createHomePage());
        app.setHomePageTitle("Home");

        HtmlPageBuilder custom = new HtmlPageBuilder();
        custom.addNavElements("home", "about", "policy");

        String paragraph =
                """
                Lorem Ipsum is simply dummy text of the printing and typesetting industry.\040
                Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\040
                when an unknown printer took a galley of type and scrambled it to make a type specimen book.
                It has survived not only five centuries, but also the leap into electronic typesetting,\040
                remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset\040
                sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like\040
                Aldus PageMaker including versions of Lorem Ipsum.
                """;
        custom.addMainSection("Test Of Custom Page", paragraph);
        custom.addFooterSection("Far from home 4A", "47897364", "example@gmail.com");

        app.addCustomHtmlPage(custom.build());
        app.run();


    }
}