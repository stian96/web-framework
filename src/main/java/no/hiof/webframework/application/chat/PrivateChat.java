package no.hiof.webframework.application.chat;

import no.hiof.webframework.Interface.ChatStrategy;

import java.util.ArrayList;
import java.util.List;
/**
 * A chat strategy for private chats between two users.
 */
public class PrivateChat implements ChatStrategy {
    private ChatUser user1;
    private ChatUser user2;
    private final List<String> messages;


    public PrivateChat() {
        messages = new ArrayList<>();
    }

    @Override
    public void sendMessage(ChatUser sender, String message) {
        if (isValidUser(sender)) {
            String formattedMessage = sender.getName() + ": " + message;
            messages.add(formattedMessage);
            sender.setLatestMessage(message);
        }
        else
            throw new IllegalArgumentException("Sender is not part of this private chat.");
    }

    @Override
    public void receiveMessage(ChatUser sender, String message) {
        if (isValidUser(sender))
            System.out.printf("User %s received a message: %s%n", sender.getName(), message);
        else
            throw new IllegalArgumentException("Invalid user trying to receive a message.");
    }

    @Override
    public List<String> getChatHistory() {
        return messages;
    }

    @Override
    public void addUser(ChatUser user) {
        this.user1 = user;
    }

    private boolean isValidUser(ChatUser user) {
        return user.equals(user1) || user.equals(user2);
    }
}
