package edu.msoft.customerms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final String someProperty;

    private final IRSClient irsClient;

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController (CustomerRepository customerRepository,
                               @Value("${customer.some-property}") String someProperty,
                               IRSClient irsClient) {
        this.customerRepository = customerRepository;
        this.someProperty = someProperty;
        this.irsClient = irsClient;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        logger.info("Creating customer with name {}", customer.getName());
        return new ResponseEntity<>(this.customerRepository.save(customer), HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        logger.info("Getting all customers");
        return new ResponseEntity<>(this.customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable Long id) {
        logger.info("Getting customer with id {}", id);
        return this.customerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    @GetMapping("/customer/property")
    public ResponseEntity<String> getCustomerProperty() {
        logger.info("Getting customer test property: {}", this.someProperty);
        return new ResponseEntity<>(this.someProperty, HttpStatus.OK);
    }

    @GetMapping("/customer/pid")
    public ResponseEntity<String> getPID() {
        logger.info("Getting customer PID: {}", System.getProperty("PID"));
        return new ResponseEntity<>(System.getProperty("PID"), HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}/full-history")
    public ResponseEntity<CustomerFullHistory> getCustomerFullHistory (@PathVariable Long customerId) {

        logger.info("Getting customer full history");

        Optional<Customer> customer = this.customerRepository.findById(customerId);

        if (customer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(new CustomerFullHistory(customer.get(),
                irsClient.getEarningsByCustomerId(customerId).getBody()), HttpStatus.OK);
    }

}
