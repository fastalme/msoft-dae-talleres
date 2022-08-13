package edu.msoft.customerms.app;

import edu.msoft.customerms.infra.db.Customer;

import java.util.List;

public interface ForSavingCustomers {

    Customer saveCustomer(Customer customer);
    List<Customer> findAll();

}
