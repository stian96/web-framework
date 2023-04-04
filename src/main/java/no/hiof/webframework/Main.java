package no.hiof.webframework;


import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Frontend.HtmlFactory;
import org.eclipse.jetty.http.HttpMethod;

public class Main {
    public static void main(String[] args)
    {
        App app = App.create();
        app.setApplicationTitle("My first application!");
        app.addRoute("login", HttpMethod.GET);

        HtmlFactory factory = new HtmlFactory();
        app.addHtmlPage(factory.createLoginPage(), "Login");
        app.run();

    }
}