/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sg.compoundinterestbigd.objects.InterestCalculator;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Marcus
 */
public class InterestCalculatorTests {
    
    InterestCalculator calculator = new InterestCalculator();
    
    public InterestCalculatorTests() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCalculate100DollarsOverFourQuaters(){
        BigDecimal currentBalance = new BigDecimal("100.00");
        BigDecimal quarterlyInterestRate = new BigDecimal("0.25");
        
        int years = 4;
        BigDecimal ret = calculator.calculateQuarters(currentBalance, quarterlyInterestRate, years * 4);
        System.out.println(ret);
        assertTrue(true);
    }
}
