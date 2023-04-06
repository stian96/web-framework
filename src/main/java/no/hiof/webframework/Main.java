package no.hiof.webframework;
import no.hiof.webframework.Application.App;
import no.hiof.webframework.SpringBoot.Chatroom;


public class Main {
    public static void main(String[] args) throws Exception {

        App app = App.create();
        app.addChatRoom(Chatroom.create());
        app.run();
    }
}