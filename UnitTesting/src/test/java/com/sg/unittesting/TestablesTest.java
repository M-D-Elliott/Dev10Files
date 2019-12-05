
package com.sg.unittesting;

import com.sg.unittesting.firstwave.Testables;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class TestablesTest {
    
    Testables testables = new Testables();
    
    public TestablesTest() {
    }
     
    @Test
    public void teststringTimesHi2() {
        assertEquals("HiHi", testables.stringTimes("Hi", 2));
    }
    
    @Test
    public void teststringTimesHi1() {
        assertEquals("Hi", testables.stringTimes("Hi", 1));
    }
    
    @Test
    public void teststringTimesHi3() {
        assertEquals("HiHiHi", testables.stringTimes("Hi", 3));
    }
    
    @Test
    public void testAbbaHiBye() {
        assertEquals("HiByeByeHi", testables.abba("Hi", "Bye"));
    }
    
    @Test
    public void testAbbaYoAlice() {
        assertEquals("YoAliceAliceYo", testables.abba("Yo", "Alice"));
    }
    
    @Test
    public void testAbbaWhatUp() {
        assertEquals("WhatUpUpWhat", testables.abba("What", "Up"));
    }
    
    @Test
    public void testcanHazTable510() {
        assertEquals(2, testables.canHazTable(5, 10));
    }
    
    @Test
    public void testcanHazTable52() {
        assertEquals(0, testables.canHazTable(5, 2));
    }
    
    @Test
    public void testcanHazTable35() {
        assertEquals(1, testables.canHazTable(3, 5));
    }
    
    @Test
    public void testfrontTimesChocolate2() {
        assertEquals("ChoCho", testables.frontTimes("Chocolate", 2));
    }
    
    @Test
    public void testfrontTimesChocolate3() {
        assertEquals("ChoChoCho", testables.frontTimes("Chocolate", 3));
    }
    
    @Test
    public void testfrontTimesAbc3() {
        assertEquals("AbcAbcAbc", testables.frontTimes("Abc", 3));
    }
    
    @Test
    public void testfirstLast6126() {
        assertTrue(testables.firstLast6(new int[]{1, 2, 6}));
    }
    
    @Test
    public void testfirstLast66123() {
        assertTrue(testables.firstLast6(new int[]{6, 1, 2, 3}));
    }
    
    @Test
    public void testfirstLast6136123() {
        assertFalse(testables.firstLast6(new int[]{13, 6, 1, 2, 3}));
    }
    
    @Test
    public void testsameFirstLast123() {
        assertFalse(testables.firstLast6(new int[]{1,2,3}));
    }
    
    @Test
    public void testsameFirstLast1231() {
        assertTrue(testables.firstLast6(new int[]{1,2,3,1}));
    }
    
    @Test
    public void testsameFirstLast121() {
        assertTrue(testables.firstLast6(new int[]{1,2,1}));
    }
    
    @Test
    public void testcanSleepInfalsefalse() {
        assertTrue(testables.canSleepIn(false, false));
    }
    
    @Test
    public void testcanSleepIntruefalse() {
        assertFalse(testables.canSleepIn(true, false));
    }
    
    @Test
    public void testcanSleepInfalsetrue() {
        assertTrue(testables.canSleepIn(false, true));
    }
}
