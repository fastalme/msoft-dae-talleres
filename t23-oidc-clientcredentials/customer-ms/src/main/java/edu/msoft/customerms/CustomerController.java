package edu.msoft.customerms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/customer")
    @PreAuthorize("hasAuthority('SCOPE_customers:write')")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer, Authentication auth) {
        LOGGER.info("{} is saving a new customer", auth.getName());
        return new ResponseEntity<>(this.customerRepository.save(customer), HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('SCOPE_customers:read')")
    public ResponseEntity<List<Customer>> getAllCustomers(Authentication auth) {
        LOGGER.info("{} is querying the list of all customers", auth.getName());
        return new ResponseEntity<>(this.customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    @PreAuthorize("hasAuthority('SCOPE_customers:read')")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable Long id, Authentication auth) {
        LOGGER.info("{} is is querying customer with ID {}", auth.getName(), id);
        return this.customerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
