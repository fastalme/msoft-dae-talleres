package edu.msoft.customerms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

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

        this.customerRepository.saveAll(List.of(new Customer("John", "Doe", LocalDate.of(2020, 5, 19)),
                new Customer("Alice", "Doe", LocalDate.of(2018, 11, 24))));

    }

}
