package no.hiof.webframework.SpringBoot.Controller;
import no.hiof.webframework.SpringBoot.Model.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
public class ChatController {

    @Autowired
    private SimpMessageSendingOperations template;

    @GetMapping("/chat")
    public String chatService() {
        return "index.html";
    }

    @MessageMapping("/sendMessage")
    @SendTo("/subject/public")
    public ChatService sendMessage(@Payload ChatService chatMessage) {
        return chatMessage;
    }


    @MessageMapping("/addUser")
    @SendTo("/subject/public")
    public ChatService addUser(@Payload ChatService chat,
                               SimpMessageHeaderAccessor accessor) {
        // Add username in web socket session
        Objects.requireNonNull(accessor.getSessionAttributes()).put("username", chat.getSender());
        return chat;
    }
}
