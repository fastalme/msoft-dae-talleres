package edu.msoft.irsms;

import java.math.BigDecimal;

public record Earning (Long customerId, Short year, BigDecimal amount) {}
