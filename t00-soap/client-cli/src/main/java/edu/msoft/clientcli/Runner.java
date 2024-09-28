package edu.msoft.clientcli;

import com.learnwebservices.services.hello.HelloEndpoint;
import com.learnwebservices.services.hello.HelloRequest;
import com.learnwebservices.services.hello.HelloResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner
        implements CommandLineRunner {

    private final HelloEndpoint helloEndpoint;

    public Runner(HelloEndpoint helloEndpoint) {
        this.helloEndpoint = helloEndpoint;
    }

    @Override
    public void run(String... args)
            throws Exception {

        HelloRequest request = new HelloRequest();
        request.setName("John Doe from Java");

        HelloResponse response = helloEndpoint.sayHello(request);

        System.out.println(response.getMessage());

    }

}
