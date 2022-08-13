package edu.msoft.customerms;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {

        if (customer == null) {
            throw new RuntimeException("Customer cannot be null");
        }
        if (!StringUtils.hasText(customer.getName())) {
            throw new RuntimeException("Customer name cannot be null or empty");
        }

        return this.customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

}
