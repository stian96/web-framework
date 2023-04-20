package no.hiof.webframework.SpringBoot.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;


@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private ChatProperties chatProperties;


    @Override
    public void registerStompEndpoints(StompEndpointRegistry register) {
        register.addEndpoint(chatProperties.getWsEndpoint()).withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry register) {
        register.setApplicationDestinationPrefixes(chatProperties.getAppDestinationPrefix());
        register.enableSimpleBroker(chatProperties.getBrokerPrefix());
    }
}
