package no.hiof.webframework;

import no.hiof.webframework.Application.App;
import no.hiof.webframework.Exceptions.HttpMethodException;
import no.hiof.webframework.Frontend.HtmlPageBuilder;
import org.eclipse.jetty.http.HttpMethod;


public class Main {
    public static void main(String[] args) throws HttpMethodException {

        App app = new App();
        app.setTitle("My first application!");
        app.addRoute("custom", HttpMethod.GET);

        HtmlPageBuilder builder = new HtmlPageBuilder();
        builder.addHeader("Custom html form example");
        builder.addForm( HttpMethod.POST,"username", "password", "email", "date");
        app.addCustomHtmlPage(builder.build());

        app.run();
    }
}