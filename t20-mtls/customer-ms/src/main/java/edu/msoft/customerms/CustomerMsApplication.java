package edu.msoft.customerms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CustomerMsApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public CustomerMsApplication (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main (String[] args) {
        SpringApplication.run(CustomerMsApplication.class, args);
    }

    @Override
    public void run (String... args) throws Exception {
        this.customerRepository.save(new Customer("John", "Doe", LocalDate.of(2001, 4, 8)));
    }

}
