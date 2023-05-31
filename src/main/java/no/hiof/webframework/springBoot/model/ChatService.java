package no.hiof.webframework.springBoot.model;

/**
 * Represents a chat service message.
 */
public class ChatService {
    private MessageType type;
    private String content;
    private String sender;

    /**
     * Enum representing different types of chat service messages.
     */
    public enum MessageType {
        /**
         * Represents a regular chat message.
         */
        CHAT,

        /**
         * Represents a connection message.
         */
        CONNECT,

        /**
         * Represents a disconnection message.
         */
        DISCONNECT,
    }

    /**
     * Retrieves the type of the chat service message.
     *
     * @return the message type
     */
    public MessageType getType() {
        return type;
    }

    /**
     * Sets the type of the chat service message.
     *
     * @param type the message type to set
     */
    public void setType(MessageType type) {
        this.type = type;
    }

    /**
     * Retrieves the content of the chat service message.
     *
     * @return the message content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the chat service message.
     *
     * @param content the message content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Retrieves the sender of the chat service message.
     *
     * @return the message sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets the sender of the chat service message.
     *
     * @param sender the message sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }
}
