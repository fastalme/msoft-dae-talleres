package edu.msoft.clientcli;

import edu.msoft.clientcli.ref.hello.HelloEndpoint;
import edu.msoft.clientcli.ref.hello.HelloRequest;
import edu.msoft.clientcli.ref.hello.HelloResponse;
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
        request.setName("John Doe");

        HelloResponse response = helloEndpoint.sayHello(request);

        System.out.println(response.getMessage());

    }

}
