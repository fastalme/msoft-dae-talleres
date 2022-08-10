package edu.msoft.customerms;

public class CustomerFullHistory {

    private Customer customer;
    private EarningsReport earnings;

    public CustomerFullHistory () {
    }

    public CustomerFullHistory (Customer customer, EarningsReport earnings) {
        this.customer = customer;
        this.earnings = earnings;
    }

    public Customer getCustomer () {
        return customer;
    }

    public void setCustomer (Customer customer) {
        this.customer = customer;
    }

    public EarningsReport getEarnings () {
        return earnings;
    }

    public void setEarnings (EarningsReport earnings) {
        this.earnings = earnings;
    }

}
