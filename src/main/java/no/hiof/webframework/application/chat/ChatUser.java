package no.hiof.webframework.application.chat;

/**
 * Represents a chat user.
 */
public class ChatUser {
    private String name;
    private String latestMessage;

    /**
     * Constructs a new ChatUser object with the specified name.
     *
     * @param name the name of the chat user
     */
    public ChatUser(String name) {
        this.name = name;
    }

    /**
     * Sets the latest message for the chat user.
     *
     * @param message the latest message to set
     */
    public void setLatestMessage(String message) {
        this.latestMessage = message;
    }

    /**
     * Retrieves the latest message of the chat user.
     *
     * @return the latest message
     */
    public String getLatestMessage() {
        return latestMessage;
    }

    /**
     * Retrieves the name of the chat user.
     *
     * @return the name of the chat user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the chat user.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
