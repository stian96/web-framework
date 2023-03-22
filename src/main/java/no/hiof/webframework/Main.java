package no.hiof.webframework;


import no.hiof.webframework.Application.App;
import no.hiof.webframework.Frontend.HtmlPageBuilder;
import org.eclipse.jetty.http.HttpMethod;

public class Main {
    public static void main(String[] args) {

        App myApp = App.create();
        myApp.addRoute("custom", HttpMethod.GET);

        // Builder to create custom html pages.
        HtmlPageBuilder builder = new HtmlPageBuilder();


        // Adds elements in a navbar.
        builder.addNavElements("home", "about", "contact");

        String paragraph = """
                           Contrary to popular belief, Lorem Ipsum is not simply random text. 
                           It has roots in a piece of classical Latin literature from 45 BC, 
                           making it over 2000 years old. Richard McClintock, a Latin professor 
                           at Hampden-Sydney College in Virginia, looked up one of the more obscure 
                           Latin words, consectetur, from a Lorem Ipsum passage, and going through 
                           the cites of the word in classical literature, discovered the undoubtable 
                           """;
        // Adds a main section with a header and a paragraph.
        builder.addMainSection("Main section", paragraph);

        // Adds a footer section with contact information.
        builder.addFooterSection("Home-street 5B", "46578987", "example@gmail.com");

        // Send the html page as a string to the addCustomHtmlPage method.
        myApp.addCustomHtmlPage(builder.build());
        myApp.run();
    }
}