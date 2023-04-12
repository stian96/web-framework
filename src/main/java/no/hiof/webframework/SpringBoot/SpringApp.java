package no.hiof.webframework.SpringBoot;
import no.hiof.webframework.SpringBoot.Config.ChatProperties;
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
