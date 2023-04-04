package no.hiof.webframework.Application.Chat;

import no.hiof.webframework.Data.User;
import no.hiof.webframework.Interface.ChatStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class GroupChat implements ChatStrategy {

    private List<ChatUser> chatUsers;
    private List<String> messages;

    public GroupChat(ChatUser ...users) {
        chatUsers = new ArrayList<>();
        chatUsers.addAll(Arrays.asList(users));
        messages = new ArrayList<>();
    }

    @Override
    public void sendMessage(ChatUser sender, String message) {
        if (isValidUser(sender)) {
            String formattedMessage = sender.getName() + ": " + message;
            messages.add(formattedMessage);
            for (ChatUser chatUser : chatUsers) {
                if (!chatUser.equals(sender)) {
                    receiveMessage(chatUser, formattedMessage);
                }
            }
        } else {
            throw new IllegalArgumentException("Sender is not part of this group chat.");
        }

    }

    @Override
    public void receiveMessage(ChatUser receiver, String message) {
        System.out.printf("User %s received a message: %s%n", receiver.getName(), message);

    }

    @Override
    public List<String> getChatHistory() {
        return messages;
    }

    private boolean isValidUser(ChatUser user) {
        return chatUsers.contains(user);
    }

    public List<ChatUser> getChatUsers() {
        return chatUsers;
    }

    public void setChatUsers(List<ChatUser> chatUsers) {
        this.chatUsers = chatUsers;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
