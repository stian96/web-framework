package no.hiof.webframework.Interface;

import no.hiof.webframework.Data.User;

import java.util.List;

/**
 * An interface that defines the behavior of a chat strategy. Implementations of this
 * interface can be used to define different types of chat rooms, such as one-on-one chats
 * or group chats.
 */
public interface ChatStrategy {
    /**
     * Sends a message from a sender to other users in the chat room.
     *
     * @param sender the user sending the message
     * @param message the message to be sent
     */
    void sendMessage(User sender, String message);
    /**
     * Receives a message from a sender in the chat room.
     *
     * @param sender the user who sent the message
     * @param message the message that was received
     */
    void receiveMessage(User sender, String message);
    /**
     * Gets the chat history for the chat room.
     *
     * @return a list of strings representing the chat history
     */
    List<String> getChatHistory();
}
