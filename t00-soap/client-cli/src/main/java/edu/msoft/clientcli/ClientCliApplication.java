package edu.msoft.clientcli;

import com.learnwebservices.services.hello.HelloEndpoint;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientCliApplication {

    @Value("${hello-service.url:https://apps.learnwebservices.com/services/hello}")
    private String url;

    public static void main(String[] args) {
        SpringApplication.run(ClientCliApplication.class, args);
    }

    @Bean
    public HelloEndpoint helloEndpoint() {

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloEndpoint.class);
        factory.setAddress(url);

        return (HelloEndpoint) factory.create();
    }

}
