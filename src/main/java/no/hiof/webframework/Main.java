package no.hiof.webframework;


import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Frontend.HtmlFactory;
import org.eclipse.jetty.http.HttpMethod;

public class Main {
    public static void main(String[] args) {

        App myApp = App.create();
        myApp.addRoute("home", HttpMethod.GET);
        myApp.addRoute("login", HttpMethod.GET);
        myApp.addRoute("logout", HttpMethod.GET);

        HtmlFactory factory = new HtmlFactory();

        myApp.run();

    }
}