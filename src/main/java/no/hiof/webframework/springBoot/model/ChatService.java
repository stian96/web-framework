package no.hiof.webframework.springBoot.model;

public class ChatService {
    private MessageType type;
    private String content;
    private String sender;


    public enum MessageType {
        CHAT,
        CONNECT,
        DISCONNECT,
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
