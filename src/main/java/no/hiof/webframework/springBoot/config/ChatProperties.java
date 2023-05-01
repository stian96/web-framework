package no.hiof.webframework.springBoot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "chat")
public class ChatProperties {

    // WebSocket endpoint.
    private String websocketEndpoint = "/ws";

    // MessageRoute endpoint used to decide what messages
    // should be treated by the server.
    private String applicationEndpoint = "/chat";

    // Used to decide which messages should be sent to
    // subscribed users.
    private String messageBrokerEndpoint = "/subject/public";

    public String getWsEndpoint() {
        return websocketEndpoint;
    }

    public void setWsEndpoint(String wsEndpoint) {
        this.websocketEndpoint = wsEndpoint;
    }

    public String getAppDestinationPrefix() {
        return applicationEndpoint;
    }

    public void setAppDestinationPrefix(String appDestinationPrefix) {
        this.applicationEndpoint = appDestinationPrefix;
    }

    public String getBrokerPrefix() {
        return messageBrokerEndpoint;
    }

    public void setBrokerPrefix(String brokerPrefix) {
        this.messageBrokerEndpoint = brokerPrefix;
    }

}
