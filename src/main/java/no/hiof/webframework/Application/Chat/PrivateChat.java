package no.hiof.webframework.Application.Chat;

import no.hiof.webframework.Data.User;
import no.hiof.webframework.Interface.ChatStrategy;

import java.util.ArrayList;
import java.util.List;
/**
 * A chat strategy for private chats between two users.
 */
public class PrivateChat implements ChatStrategy {
    private ChatUser user1;
    private ChatUser user2;
    private List<String> messages;

    public PrivateChat() {}

    public PrivateChat(ChatUser user1, ChatUser user2) {
        this.user1 = user1;
        this.user2 = user2;
        messages = new ArrayList<>();
    }

    @Override
    public void sendMessage(ChatUser sender, String message) {
        if (sender.equals(user1) || sender.equals(user2)) {
            String formattedMessage = sender.getName() + ": " + message;
            messages.add(formattedMessage);
        }
        else
            throw new IllegalArgumentException("Sender is not part of this private chat.");
    }

    @Override
    public void receiveMessage(ChatUser sender, String message) {
        sendMessage(sender, message);
    }

    @Override
    public List<String> getChatHistory() {
        return messages;
    }
}
