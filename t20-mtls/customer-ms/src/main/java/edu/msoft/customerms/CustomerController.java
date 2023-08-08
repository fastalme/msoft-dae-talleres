package edu.msoft.customerms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
    public static final String LOG_STRING = "{}: {}";
    public static final String X_CERT_ISSUER = "X-Cert-Issuer";
    public static final String X_CERT_SUBJECT = "X-Cert-Subject";
    public static final String X_CERT_VERIFY = "X-Cert-Verify";

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(this.customerRepository.save(customer), HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(HttpServletRequest request) {

        String xCertIssuerHeaderValue = request.getHeader(X_CERT_ISSUER);
        String xCertSubjectHeaderValue = request.getHeader(X_CERT_SUBJECT);
        String xCertVerifyHeaderValue = request.getHeader(X_CERT_VERIFY);

        LOG.info(LOG_STRING, X_CERT_ISSUER, xCertIssuerHeaderValue);
        LOG.info(LOG_STRING, X_CERT_SUBJECT, xCertSubjectHeaderValue);
        LOG.info(LOG_STRING, X_CERT_VERIFY, xCertVerifyHeaderValue);

        return new ResponseEntity<>(this.customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable Long id) {
        return this.customerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
