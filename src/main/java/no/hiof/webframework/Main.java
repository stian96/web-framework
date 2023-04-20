package no.hiof.webframework;
import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Chatroom;
import no.hiof.webframework.Application.Enums.ChatMethod;
import no.hiof.webframework.Application.Enums.ImageType;
import no.hiof.webframework.Application.Enums.Options;


public class Main {
    public static void main(String[] args) throws Exception {

        App app = App.create();

        Chatroom.setChatMethod(ChatMethod.PRIVATE);
        Chatroom.addMessageTimeStamp(true);

        Chatroom.addDeleteMessagesButton(Options.YES);
        Chatroom.setTitle("Welcome to private chat!");

        Chatroom.addIconImageToChat("path/to/image/icon1.jpg");
        Chatroom.addIconImageToChat("path/to/image/icon2.jpg");

        Chatroom.overrideExistingIconImage("path/to/image/override.jpg", ImageType.DEFAULT_1);
        app.addChatRoom(Chatroom.create());
        app.run();

    }
}