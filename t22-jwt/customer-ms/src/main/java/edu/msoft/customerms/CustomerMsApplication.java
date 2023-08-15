package edu.msoft.customerms;

import edu.msoft.customerms.security.User;
import edu.msoft.customerms.security.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class CustomerMsApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    public CustomerMsApplication (UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    public static void main (String[] args) {
        SpringApplication.run(CustomerMsApplication.class, args);
    }

    @Bean
    public PasswordEncoder encoder () {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void run (String... args) throws Exception {

        userRepository.save(new User("user", encoder().encode("user")));

        customerRepository.save(new Customer("John", "Doe", LocalDate.of(2001, 4, 24)));

    }

}
