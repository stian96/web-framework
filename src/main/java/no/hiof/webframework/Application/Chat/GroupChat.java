package no.hiof.webframework.Application.Chat;

import no.hiof.webframework.Data.User;
import no.hiof.webframework.Interface.ChatStrategy;

import java.util.List;

public class GroupChat implements ChatStrategy {
    @Override
    public void sendMessage(ChatUser sender, String message) {

    }

    @Override
    public void receiveMessage(ChatUser sender, String message) {

    }

    @Override
    public List<String> getChatHistory() {
        return null;
    }
}
