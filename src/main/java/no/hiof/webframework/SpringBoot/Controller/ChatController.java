package no.hiof.webframework.SpringBoot.Controller;
import no.hiof.webframework.SpringBoot.Config.ChatProperties;
import no.hiof.webframework.SpringBoot.Model.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
class ChatController {

    @Autowired
    private ChatProperties chatProperties;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/sendMessage")
    public void sendMessage(@Payload ChatService chatMessage) {
        messagingTemplate.convertAndSend(chatProperties.getBrokerPrefix(), chatMessage);
    }


    @MessageMapping("/addUser")
    public void addUser(@Payload ChatService chat, SimpMessageHeaderAccessor accessor) {
        // Add username in web socket session
        Objects.requireNonNull(accessor.getSessionAttributes()).put("username", chat.getSender());
        messagingTemplate.convertAndSend(chatProperties.getBrokerPrefix(), chat);
    }
}
