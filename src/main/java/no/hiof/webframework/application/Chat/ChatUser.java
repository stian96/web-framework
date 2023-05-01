package no.hiof.webframework.application.Chat;

public class ChatUser {
    private String name;
    private String latestMessage;


    public ChatUser(String name) {
        this.name = name;
    }

    public void setLatestMessage(String message) {
        this.latestMessage = message;
    }

    public String getLatestMessage() {
        return latestMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
