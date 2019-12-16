package com.sg.javamilestone3.intmath;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalFun {
    public void run(){
        System.out.println(new BigDecimal(0.1));
        System.out.println(new BigDecimal("0.1"));
        
        BigDecimal a = new BigDecimal("42.35");
        BigDecimal b = a.setScale(1);
        // Error
        b = a.setScale(1, RoundingMode.HALF_UP);
        System.out.println(b.toString()); // 42.4
        
        b = a.setScale(1, RoundingMode.HALF_DOWN);
        System.out.println(b.toString()); // 42.3
        
        BigDecimal op1 = new BigDecimal("10");
        BigDecimal op2 = new BigDecimal("6");
        BigDecimal c = op1.divide(op2); // ERROR
        
        c = op1.divide(op2, RoundingMode.HALF_UP); // 2
        System.out.println(c.toString());

        c = op1.divide(op2, 2, RoundingMode.HALF_UP); // 1.67
        System.out.println(c.toString());

        c = op1.divide(op2, 2, RoundingMode.DOWN); // 1.66
        System.out.println(c.toString());
        
//        rules for the course:
//        Scale = 2
//        Rounding = HALF_UP
    }
}
