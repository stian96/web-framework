package no.hiof.webframework.SpringBoot.Controller;

import no.hiof.webframework.SpringBoot.Config.ChatProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatConfigController {

    @Autowired
    private ChatProperties chatProperties;


    @GetMapping("/api/chat-config")
    public ChatProperties getChatConfig() {
        ChatProperties chatConfig = new ChatProperties();
        chatConfig.setWsEndpoint(chatProperties.getWsEndpoint());
        chatConfig.setBrokerPrefix(chatProperties.getBrokerPrefix());
        chatConfig.setAppDestinationPrefix(chatProperties.getAppDestinationPrefix());
        return chatConfig;
    }
}
