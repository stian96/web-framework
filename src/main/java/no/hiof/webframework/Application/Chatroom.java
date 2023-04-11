package no.hiof.webframework.Application;


import no.hiof.webframework.SpringBoot.SpringApp;

public class Chatroom {

    private static Chatroom instance = null;

    private Chatroom() {}

    public static Chatroom create() {
        if (instance == null) {
            instance = new Chatroom();
        }
        return instance;
    }

    protected void startChatRoom() {
        SpringApp.run();
    }
}

