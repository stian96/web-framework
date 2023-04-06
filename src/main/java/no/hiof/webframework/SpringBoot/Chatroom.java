package no.hiof.webframework.SpringBoot;

public class Chatroom {

    private static Chatroom instance = null;

    private Chatroom() {
        SpringApp.run();
    }

    public static Chatroom create() {
        if (instance == null) {
            instance = new Chatroom();
        }
        return instance;

    }
}
