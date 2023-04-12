package no.hiof.webframework.SpringBoot.Config;

import no.hiof.webframework.Servlet.SpringServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SpringServletConfig {

    @Bean
    public ServletRegistrationBean<SpringServlet> myServlet() {
        return new ServletRegistrationBean<>(new SpringServlet(), "/springServlet");
    }
}
