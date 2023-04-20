package no.hiof.webframework;
import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Chatroom;
import no.hiof.webframework.Application.Enums.ChatMethod;
import no.hiof.webframework.Application.Enums.Options;


public class Main {
    public static void main(String[] args) throws Exception {

        App app = App.create();

        Chatroom.setChatMethod(ChatMethod.PRIVATE);
        Chatroom.addMessageTimeStamp(true);

        Chatroom.addDeleteMessagesButton(Options.YES);
        Chatroom.setTitle("Welcome to private chat!");

        app.addChatRoom(Chatroom.create());
        app.run();

    }
}