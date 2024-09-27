package edu.msoft.hellows;

import com.learnwebservices.services.hello.HelloEndpoint;
import com.learnwebservices.services.hello.HelloRequest;
import com.learnwebservices.services.hello.HelloResponse;
import org.springframework.stereotype.Component;

@Component
public class HelloEndpointWS implements HelloEndpoint {

    @Override
    public HelloResponse sayHello(HelloRequest helloRequest) {

        HelloResponse response = new HelloResponse();
        response.setMessage("Hola " + helloRequest.getName() + "!!!");
        return response;

    }

}
