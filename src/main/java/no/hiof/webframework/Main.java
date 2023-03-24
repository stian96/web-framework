package no.hiof.webframework;


import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Frontend.HtmlFactory;
import no.hiof.webframework.Controllers.MyController;
import org.eclipse.jetty.http.HttpMethod;

public class Main {
    public static void main(String[] args) {

        App myApp = App.create();
        myApp.addRoute("default", HttpMethod.GET);
        myApp.addResponseToPage("This is my first response to a empty page.");
        myApp.run();

    }
}