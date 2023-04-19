package no.hiof.webframework;
import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Chatroom;
import no.hiof.webframework.Application.Enums.ChatMethod;


public class Main {
    public static void main(String[] args) throws Exception {

        App app = App.create();

        Chatroom.setChatMethod(ChatMethod.PRIVATE);
        Chatroom.addMessageTimeStamp(true);

        app.addChatRoom(Chatroom.create());
        app.run();

    }
}