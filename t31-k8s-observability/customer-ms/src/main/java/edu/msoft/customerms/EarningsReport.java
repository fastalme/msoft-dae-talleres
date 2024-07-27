package edu.msoft.customerms;

import java.util.List;

public record EarningsReport (List<Earning> earnings, String sourcePID, String sourceHostname) { }
