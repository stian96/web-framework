package no.hiof.webframework.springBoot;
import no.hiof.webframework.springBoot.config.ChatProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ChatProperties.class)
public class SpringApp {

    public static void run() {
        SpringApplication.run(SpringApp.class);
    }

}
