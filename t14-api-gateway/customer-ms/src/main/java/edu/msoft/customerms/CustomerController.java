package edu.msoft.customerms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final String someProperty;

    private final IRSClient irsClient;

    public CustomerController(CustomerRepository customerRepository,
                              @Value("${customer.some-property}") String someProperty,
                              IRSClient irsClient) {
        this.customerRepository = customerRepository;
        this.someProperty = someProperty;
        this.irsClient = irsClient;
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

    @GetMapping("/customer/{customerId}/full-history")
    public ResponseEntity<CustomerFullHistory> getCustomerFullHistory (@PathVariable Long customerId) {

        Optional<Customer> customer = this.customerRepository.findById(customerId);

        if (customer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(new CustomerFullHistory(customer.get(),
                irsClient.getEarningsByCustomerId(customerId).getBody()), HttpStatus.OK);
    }

}
