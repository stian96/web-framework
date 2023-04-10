package no.hiof.webframework.SpringBoot.Model;

public class ChatService {
    private MessageType type;
    private String content;
    private String sender;

    private String recipient;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE,
        PRIVATE
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
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
