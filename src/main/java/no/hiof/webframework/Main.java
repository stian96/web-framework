package no.hiof.webframework;

import no.hiof.webframework.Application.App;
import no.hiof.webframework.Data.LoginData;
import no.hiof.webframework.Frontend.HtmlFactory;
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
        app.run();
    }
}