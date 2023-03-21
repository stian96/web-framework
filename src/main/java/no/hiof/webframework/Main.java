package no.hiof.webframework;
import no.hiof.webframework.Application.App;
import no.hiof.webframework.Frontend.HtmlFactory;
import org.eclipse.jetty.http.HttpMethod;


public class Main {
    public static void main(String[] args) throws Exception {

        App app = new App();
        app.setApplicationTitle("hello world");
        app.addRoute("login", HttpMethod.GET);
        app.addRoute("home", HttpMethod.GET);

        HtmlFactory factory = new HtmlFactory();
        app.addHtmlPage(factory.createLoginPage(), "Hello login page");
        app.addHtmlPage(factory.createHomePage(), "Home is the best!");

        app.run();

    }
}