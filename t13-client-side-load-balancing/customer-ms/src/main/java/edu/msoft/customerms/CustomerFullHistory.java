package edu.msoft.customerms;

import java.util.List;

public class CustomerFullHistory {

    private Customer customer;
    private List<Earnings> earnings;

    public CustomerFullHistory () {
    }

    public CustomerFullHistory (Customer customer, List<Earnings> earnings) {
        this.customer = customer;
        this.earnings = earnings;
    }

    public Customer getCustomer () {
        return customer;
    }

    public void setCustomer (Customer customer) {
        this.customer = customer;
    }

    public List<Earnings> getEarnings () {
        return earnings;
    }

    public void setEarnings (List<Earnings> earnings) {
        this.earnings = earnings;
    }

}
