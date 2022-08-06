package edu.msoft.customerms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final String someProperty;

    public CustomerController(CustomerRepository customerRepository,
    		@Value("${customer.some-property}") String someProperty) {
        this.customerRepository = customerRepository;
        this.someProperty = someProperty;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(this.customerRepository.save(customer), HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(this.customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable Long id) {
        return this.customerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    @GetMapping("/customer/property")
    public ResponseEntity<String> getCustomerProperty() {
        return new ResponseEntity<>(this.someProperty, HttpStatus.OK);
    }

    @GetMapping("/pid")
    public ResponseEntity<String> getPID() {
        return new ResponseEntity<>(System.getProperty("PID"), HttpStatus.OK);
    }

}
