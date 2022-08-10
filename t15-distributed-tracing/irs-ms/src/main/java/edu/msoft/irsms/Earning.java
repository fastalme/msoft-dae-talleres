package edu.msoft.irsms;

import java.math.BigDecimal;

public class Earning {

    private Long customerId;
    private Short year;
    private BigDecimal amount;

    public Earning () {
    }

    public Earning (Long customerId, Short year, BigDecimal amount) {
        this.customerId = customerId;
        this.year = year;
        this.amount = amount;
    }

    public Long getCustomerId () {
        return customerId;
    }

    public void setCustomerId (Long customerId) {
        this.customerId = customerId;
    }

    public Short getYear () {
        return year;
    }

    public void setYear (Short year) {
        this.year = year;
    }

    public BigDecimal getAmount () {
        return amount;
    }

    public void setAmount (BigDecimal amount) {
        this.amount = amount;
    }

}
