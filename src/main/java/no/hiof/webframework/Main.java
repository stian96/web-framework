package no.hiof.webframework;
import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Chatroom;
import no.hiof.webframework.Application.Enums.ChatMethod;
import no.hiof.webframework.Application.Frontend.HtmlFactory;
import org.eclipse.jetty.http.HttpMethod;



public class Main {
    public static void main(String[] args) throws Exception {


        App app = App.create();
        app.addRoute("home", HttpMethod.GET);

        HtmlFactory factory = new HtmlFactory();
        app.addHtmlPage(factory.createHomePage(), "Home");

        Chatroom.setChatMethod(ChatMethod.GROUP);
        app.addChatRoom(Chatroom.create());

        app.run();

    }
}