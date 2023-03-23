package no.hiof.webframework.Application.Chat;

import no.hiof.webframework.Data.User;
import no.hiof.webframework.Interface.ChatStrategy;

import java.util.List;
/**
 * A chat strategy for private chats between two users.
 */
public class PrivateChat implements ChatStrategy {

    @Override
    public void sendMessage(User sender, String message) {
        // TODO: Send the message to the other user in the one-on-one chat
    }

    @Override
    public void receiveMessage(User sender, String message) {
        // TODO: Receive a message from the other user in the one-on-one chat
    }

    @Override
    public List<String> getChatHistory() {
        // TODO: Return the chat history for the one-on-one chat
        return null;
    }
}
