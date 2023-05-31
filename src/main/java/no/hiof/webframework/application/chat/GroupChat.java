package no.hiof.webframework.application.chat;

import no.hiof.webframework.interfaces.ChatStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the ChatStrategy interface representing a group chat.
 */
public class GroupChat implements ChatStrategy {

    private List<ChatUser> chatUsers;
    private List<String> messages;

    /**
     * Constructs a new GroupChat object with the specified chat users.
     *
     * @param users the chat users to be added to the group chat
     */
    public GroupChat(ChatUser... users) {
        chatUsers = new ArrayList<>();
        chatUsers.addAll(Arrays.asList(users));
        messages = new ArrayList<>();
    }

    @Override
    public void sendMessage(ChatUser sender, String message) {
        if (isValidUser(sender)) {
            String formattedMessage = sender.getName() + ": " + message;
            messages.add(formattedMessage);
            sender.setLatestMessage(message);
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

    /**
     * Checks if the given chat user is a valid user in the group chat.
     *
     * @param user the chat user to validate
     * @return true if the user is a valid user in the group chat, false otherwise
     */
    private boolean isValidUser(ChatUser user) {
        return chatUsers.contains(user);
    }

    @Override
    public void addUser(ChatUser user) {
        chatUsers.add(user);
    }

    /**
     * Retrieves the list of chat users in the group chat.
     *
     * @return the list of chat users
     */
    public List<ChatUser> getChatUsers() {
        return chatUsers;
    }

    /**
     * Sets the list of chat users in the group chat.
     *
     * @param chatUsers the list of chat users to set
     */
    public void setChatUsers(List<ChatUser> chatUsers) {
        this.chatUsers = chatUsers;
    }

    /**
     * Retrieves the list of messages in the group chat.
     *
     * @return the list of messages
     */
    public List<String> getMessages() {
        return messages;
    }

    /**
     * Sets the list of messages in the group chat.
     *
     * @param messages the list of messages to set
     */
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
