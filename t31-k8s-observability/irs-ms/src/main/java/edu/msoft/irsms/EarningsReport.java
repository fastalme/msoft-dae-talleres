package edu.msoft.irsms;

import java.util.List;

public record EarningsReport (List<Earning> earnings, String sourcePID, String sourceHostname) {}
