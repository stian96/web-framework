package no.hiof.webframework;


import no.hiof.webframework.Application.App;
import org.eclipse.jetty.http.HttpMethod;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.addRoute("response", HttpMethod.GET);
        app.addResponseToPage("Hello word!");
        app.run();
    }
}