package no.hiof.webframework;
import no.hiof.webframework.application.App;
import no.hiof.webframework.application.Chatroom;
import no.hiof.webframework.application.enums.ChatMethod;
import no.hiof.webframework.application.enums.Options;


public class Main {
    public static void main(String[] args) throws Exception {

        App app = App.create();
        Chatroom.setChatMethod(ChatMethod.PRIVATE);
        Chatroom.addDeleteMessagesButton(Options.YES);
        Chatroom.setTitle("chat club!");
        Chatroom.addMessageTimeStamp(true);

        app.addChatRoom(Chatroom.create());
        app.run();

    }
}
