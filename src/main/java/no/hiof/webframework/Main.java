package no.hiof.webframework;
import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Chat.Enum.ChatMethod;
import no.hiof.webframework.Application.Chatroom;
import no.hiof.webframework.Application.Frontend.HtmlFactory;
import org.eclipse.jetty.http.HttpMethod;



public class Main {
    public static void main(String[] args) throws Exception {


        App app = App.create();
        app.addRoute("home", HttpMethod.GET);

        HtmlFactory factory = new HtmlFactory();
        app.addHtmlPage(factory.createHomePage(), "Home");
        app.addChatRoom(Chatroom.create(), ChatMethod.GROUP);


        app.run();

    }
}