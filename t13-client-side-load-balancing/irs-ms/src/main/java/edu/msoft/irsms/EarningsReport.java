package edu.msoft.irsms;

import java.util.List;

public class EarningsReport {

    private List<Earning> earnings;
    private String sourcePID;

    public EarningsReport () {
    }

    public EarningsReport (List<Earning> earnings, String sourcePID) {
        this.earnings = earnings;
        this.sourcePID = sourcePID;
    }

    public List<Earning> getEarnings () {
        return earnings;
    }

    public void setEarnings (List<Earning> earnings) {
        this.earnings = earnings;
    }

    public String getSourcePID () {
        return sourcePID;
    }

    public void setSourcePID (String sourcePID) {
        this.sourcePID = sourcePID;
    }
    
}
