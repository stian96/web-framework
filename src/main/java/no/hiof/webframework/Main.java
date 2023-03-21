package no.hiof.webframework;

import no.hiof.webframework.Application.App;
import no.hiof.webframework.Data.User;
import no.hiof.webframework.Exceptions.HttpMethodException;
import no.hiof.webframework.Frontend.HtmlPageBuilder;
import no.hiof.webframework.Repository.UserDb;
import org.eclipse.jetty.http.HttpMethod;


public class Main {
    public static void main(String[] args) throws HttpMethodException {

        App myApp = new App();
        myApp.addRoute("login", HttpMethod.GET);

        HtmlPageBuilder builder = new HtmlPageBuilder();
        builder.addHeader("Login");
        builder.addForm(HttpMethod.POST, "username", "password");

        // save a user to the db.
        UserDb userDb = new UserDb();
        userDb.save(new User("Stian", "hello123"));
        userDb.save(new User("Ole", "heisann1"));
        userDb.save(new User("Per", "kake"));

        myApp.addCustomHtmlPage(builder.build(), userDb);
        myApp.run();
    }
}