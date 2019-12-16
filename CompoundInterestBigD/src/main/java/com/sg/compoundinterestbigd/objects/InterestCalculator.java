package com.sg.compoundinterestbigd.objects;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalculator {

    public void run() {
        BigDecimal currentBalance = new BigDecimal("100.00");
        BigDecimal quarterlyInterestRate = new BigDecimal("0.25");
        
        int years = 4;
        
        calculateQuarters(currentBalance, quarterlyInterestRate, years * 4);
    }
    
    public BigDecimal calculateQuarters(BigDecimal currentBalance, BigDecimal quarterlyInterestRate, int quarters){
        for (int i = 0; i < quarters; i++) {
            currentBalance = calculate(currentBalance, quarterlyInterestRate);
        }
        return currentBalance;
    }
    
    private BigDecimal calculate(BigDecimal currentBalance, BigDecimal quarterlyInterestRate) {
        //CurrentBalance * (1 + (QuarterlyInterestRate / 100))
        return currentBalance.multiply(BigDecimal.ONE.add(quarterlyInterestRate.divide(BigDecimal.valueOf(100))));
    }
    
}
