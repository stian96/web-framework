package no.hiof.webframework;

import no.hiof.webframework.Application.App;
import no.hiof.webframework.Frontend.HtmlPageBuilder;
import org.eclipse.jetty.http.HttpMethod;


public class Main {
    public static void main(String[] args) {

        App myApp = new App();
        myApp.addRoute("random", HttpMethod.GET);
        myApp.addDefaultPage("This is the response to a random page");
        myApp.run();
    }
}