package no.hiof.webframework;
import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Chat.Enum.ChatMethod;
import no.hiof.webframework.Application.Chatroom;
import no.hiof.webframework.Application.Frontend.HtmlFactory;
import no.hiof.webframework.Application.Parser.FileUtility;
import org.eclipse.jetty.http.HttpMethod;



public class Main {
    public static void main(String[] args) throws Exception {


        App app = App.create();
        app.addRoute("home", HttpMethod.GET);

        HtmlFactory factory = new HtmlFactory();
        app.addHtmlPage(factory.createHomePage(), "Home");
        app.addChatRoom(Chatroom.create(), ChatMethod.GROUP);

        /*
        String sourcePath = "/Users/stianrusvik/Library/Mobile Documents/com~apple~CloudDocs/Bilder/327540406_672331207970286_6963014367191948639_n.jpg";
        String destinationPath = "src/main/resources/Static/images/image2.jpg";
        FileUtility.copyFile(sourcePath, destinationPath);
         */

        app.run();

    }
}