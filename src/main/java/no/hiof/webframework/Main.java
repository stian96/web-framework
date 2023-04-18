package no.hiof.webframework;
import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Chatroom;
import no.hiof.webframework.Application.Enums.ChatMethod;
import no.hiof.webframework.Application.Frontend.HtmlPageBuilder;
import org.eclipse.jetty.http.HttpMethod;


public class Main {
    public static void main(String[] args) throws Exception {


        App app = App.create();
        app.addRoute("custom", HttpMethod.GET);

        HtmlPageBuilder builder = new HtmlPageBuilder();
        builder.addHeader("Hello World!");
        builder.addNavElements("Home", "about", "policy");

        app.addCustomHtmlPage(builder.build());

        app.run();

    }
}