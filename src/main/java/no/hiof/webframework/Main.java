package no.hiof.webframework;


import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Frontend.HtmlFactory;
import no.hiof.webframework.Controllers.MyController;
import org.eclipse.jetty.http.HttpMethod;

public class Main {
    public static void main(String[] args)
    {
        App app = App.create();
        app.addRoute("login", HttpMethod.GET);
        HtmlFactory factory = new HtmlFactory();
        app.run();

    }
}