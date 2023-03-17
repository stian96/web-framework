package no.hiof.webframework;

import no.hiof.webframework.Application.App;
import no.hiof.webframework.Enum.PageType;
import no.hiof.webframework.Frontend.HtmlFactory;
import org.eclipse.jetty.http.HttpMethod;


public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.addRoute("login", HttpMethod.GET);
        app.addRoute("home", HttpMethod.GET);

        HtmlFactory factory = new HtmlFactory();
        app.addHtmlPage(factory.createLoginPage(), "Login", PageType.LOGIN);
        app.addHtmlPage(factory.createHomePage(), "Home", PageType.HOME);
        app.run();

    }
}