package no.hiof.webframework;


import no.hiof.webframework.Application.App;
import no.hiof.webframework.Controllers.MyController;
import no.hiof.webframework.Frontend.HtmlPageBuilder;
import org.eclipse.jetty.http.HttpMethod;

public class Main {
    public static void main(String[] args) {

        App myApp = App.create();
        myApp.addController(new MyController("hello"));
        myApp.run();
    }
}