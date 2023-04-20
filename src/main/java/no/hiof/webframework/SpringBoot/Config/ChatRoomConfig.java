package no.hiof.webframework.SpringBoot.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public abstract class ChatRoomConfig {

    /**
     * Method used to set the chat properties.
     * Create a new 'ChatProperties' object and
     * set all its endpoints.
     * @return The ChatProperties object.
     */
    @Bean
    @Primary
    protected abstract ChatProperties setChatProperties();

}
