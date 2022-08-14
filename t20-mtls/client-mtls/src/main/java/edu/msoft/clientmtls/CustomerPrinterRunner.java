package edu.msoft.clientmtls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerPrinterRunner implements CommandLineRunner {

    private final CustomerClient customerClient;
    private static final Logger LOG = LoggerFactory.getLogger(CustomerPrinterRunner.class);

    public CustomerPrinterRunner (CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    @Override
    public void run (String... args) throws Exception {

        Objects.requireNonNull(customerClient.getAllCustomers().getBody())
                .forEach(customer -> LOG.info("{} {}: {}",
                        customer.getName(),
                        customer.getLastname(),
                        customer.getBirthDate()));

    }

}
