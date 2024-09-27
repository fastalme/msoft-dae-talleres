package edu.msoft.hellows;

import com.learnwebservices.services.hello.HelloEndpointService;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<CXFServlet> dispatcherServlet() {
        return new ServletRegistrationBean<>(new CXFServlet());
    }

    @Bean
    @Primary
    public DispatcherServletPath dispatcherServletPathProvider() {
        return () -> "";
    }

    @Bean(name= Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        SpringBus cxfBus = new  SpringBus();

        LoggingInInterceptor ipt = new LoggingInInterceptor();
        ipt.setPrettyLogging(true);
        cxfBus.getInInterceptors().add(ipt);

        LoggingOutInterceptor opt = new LoggingOutInterceptor();
        opt.setPrettyLogging(true);
        cxfBus.getOutInterceptors().add(opt);

        return cxfBus;
    }

    @Bean
    public Endpoint endpoint(Bus bus, HelloEndpointWS helloEndpointWS) {
        EndpointImpl endpoint = new EndpointImpl(bus, helloEndpointWS);
        endpoint.setServiceName(new HelloEndpointService().getServiceName());
        endpoint.publish("/hello");
        return endpoint;
    }

}
