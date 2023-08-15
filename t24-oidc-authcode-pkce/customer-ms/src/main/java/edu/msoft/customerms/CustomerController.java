package edu.msoft.customerms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerRepository customerRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('SCOPE_customers:manage') and hasAnyRole('ROLE_customer-basic-reader', 'ROLE_customer-advanced-reader')")
    public ResponseEntity<String> home (Authentication auth) {
        LOGGER.info("Saying Hello to {}", auth.getName());
        return new ResponseEntity<>(String.format("Hello %s", auth.getName()), HttpStatus.OK);
    }

    @PostMapping("/customer")
    @PreAuthorize("hasAuthority('SCOPE_customers:manage') and hasRole('ROLE_customer-writer')")
    public ResponseEntity<Customer> createCustomer (@RequestBody Customer customer, Authentication auth) {
        LOGGER.info("{} is saving a new customer", auth.getName());
        return new ResponseEntity<>(this.customerRepository.save(customer), HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('SCOPE_customers:manage') and hasRole('ROLE_customer-advanced-reader')")
    public ResponseEntity<List<Customer>> getAllCustomers (Authentication auth) {
        List<Customer> customerList = this.customerRepository.findAll();
        LOGGER.info("{} is querying the list of all({}) customers", auth.getName(), customerList.size());
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    @PreAuthorize("hasAuthority('SCOPE_customers:manage') and hasRole('ROLE_customer-advanced-reader')")
    public ResponseEntity<Customer> getCustomerByID (@PathVariable Long id, Authentication auth) {
        LOGGER.info("{} is is querying customer with ID {}", auth.getName(), id);
        return this.customerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
