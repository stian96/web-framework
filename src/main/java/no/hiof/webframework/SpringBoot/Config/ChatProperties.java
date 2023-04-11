package no.hiof.webframework.SpringBoot.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "chat")
public class ChatProperties {
}
