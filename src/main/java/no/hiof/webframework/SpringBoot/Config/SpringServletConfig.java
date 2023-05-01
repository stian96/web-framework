package no.hiof.webframework.SpringBoot.Config;

import no.hiof.webframework.application.SpringServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
class SpringServletConfig extends SpringServlet {


    @Bean
    public ServletRegistrationBean<SpringServlet> myServlet() {
        return new ServletRegistrationBean<>(SpringServlet.getServlet(), "/springServlet");
    }
}
