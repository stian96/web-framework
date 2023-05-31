package no.hiof.webframework.springBoot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for chat-related properties.
 */
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

    /**
     * Retrieves the WebSocket endpoint.
     *
     * @return the WebSocket endpoint
     */
    public String getWsEndpoint() {
        return websocketEndpoint;
    }

    /**
     * Sets the WebSocket endpoint.
     *
     * @param wsEndpoint the WebSocket endpoint to set
     */
    public void setWsEndpoint(String wsEndpoint) {
        this.websocketEndpoint = wsEndpoint;
    }

    /**
     * Retrieves the application destination prefix.
     *
     * @return the application destination prefix
     */
    public String getAppDestinationPrefix() {
        return applicationEndpoint;
    }

    /**
     * Sets the application destination prefix.
     *
     * @param appDestinationPrefix the application destination prefix to set
     */
    public void setAppDestinationPrefix(String appDestinationPrefix) {
        this.applicationEndpoint = appDestinationPrefix;
    }

    /**
     * Retrieves the message broker prefix.
     *
     * @return the message broker prefix
     */
    public String getBrokerPrefix() {
        return messageBrokerEndpoint;
    }

    /**
     * Sets the message broker prefix.
     *
     * @param brokerPrefix the message broker prefix to set
     */
    public void setBrokerPrefix(String brokerPrefix) {
        this.messageBrokerEndpoint = brokerPrefix;
    }
}
