package no.hiof.webframework.Application.Chat;

import no.hiof.webframework.Application.Chat.Enum.ChatMethod;
import no.hiof.webframework.Data.User;
import no.hiof.webframework.Interface.ChatStrategy;

import java.util.List;

/**
 * A chat room that allows users to send and receive messages using a specified
 * chat strategy.
 */
public class ChatRoom {
    private ChatStrategy chatStrategy;
    /**

     Creates a ChatRoom object based on the given chat method.
     @param chatMethod the type of chat method, either PRIVATE or GROUP
     @throws IllegalArgumentException if the chatMethod is null
     */
    public ChatRoom(ChatMethod chatMethod) throws IllegalArgumentException {
        if (chatMethod == null) {
            throw new IllegalArgumentException("Chat method cannot be null.");
        } else if (chatMethod == ChatMethod.PRIVATE) {
            this.chatStrategy = new PrivateChat();
        } else if (chatMethod == ChatMethod.GROUP) {
            this.chatStrategy = new GroupChat();
        }
    }

    /**
     * Sends a message from the specified sender to the chat room using the
     * chat strategy.
     *
     * @param sender the user sending the message
     * @param message the message to send
     */
    public void sendMessage(User sender, String message) {
        chatStrategy.sendMessage(sender, message);
    }
    /**
     * Receives a message from the specified sender in the chat room using the
     * chat strategy.
     *
     * @param sender the user sending the message
     * @param message the message received
     */
    public void receiveMessage(User sender, String message) {
        chatStrategy.receiveMessage(sender, message);
    }
    /**
     * Returns the chat history for the chat room using the chat strategy.
     *
     * @return a list of strings representing the chat history
     */
    public List<String> getChatHistory() {
        return chatStrategy.getChatHistory();
    }
}
