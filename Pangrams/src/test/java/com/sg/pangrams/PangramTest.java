/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.pangrams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Marcus
 */
public class PangramTest {
    
    public PangramTest() {
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
    public void testPangramShouldReturnTrue(){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        assertTrue(new Pangram().isPangram(str));
    }
    
    @Test
    public void testPangramTooFewShouldReturnFalse(){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXY";

        assertFalse(new Pangram().isPangram(str));
    }
    
    @Test
    public void testPangramOnlyOneShouldReturnFalse(){
        String str = "A";

        assertFalse(new Pangram().isPangram(str));
    }
    
    @Test
    public void testPangramNumbersShouldReturnFalse(){
        String str = "1226736732638A";

        assertFalse(new Pangram().isPangram(str));
    }
}
