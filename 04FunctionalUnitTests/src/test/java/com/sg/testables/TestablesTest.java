/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.testables;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Marcus
 */
public class TestablesTest {
    
    public TestablesTest() {
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

    /**
     * Test of commonEnd method, of class Testables.
     */
    @Test
    public void testCommonEnd() {
        System.out.println("commonEnd");
        int[] a = {1,2,3};
        int[] b = {7,3};
        Testables instance = new Testables();
        boolean expResult = true;
        boolean result = instance.commonEnd(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testCommonEnd2() {
        System.out.println("commonEnd");
        int[] a = {1,2,3};
        int[] b = {7,3,2};
        Testables instance = new Testables();
        boolean expResult = false;
        boolean result = instance.commonEnd(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testCommonEnd3() {
        System.out.println("commonEnd");
        int[] a = {1,2,3};
        int[] b = {1,3};
        Testables instance = new Testables();
        boolean expResult = true;
        boolean result = instance.commonEnd(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of doubleX method, of class Testables.
     */
    @Test
    public void testDoubleX() {
        System.out.println("doubleX");
        String str = "axxbb";
        Testables instance = new Testables();
        boolean expResult = true;
        boolean result = instance.doubleX(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testDoubleX2() {
        System.out.println("doubleX");
        String str = "axaxxax";
        Testables instance = new Testables();
        boolean expResult = true;
        boolean result = instance.doubleX(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testDoubleX3() {
        System.out.println("doubleX");
        String str = "xxxxxx";
        Testables instance = new Testables();
        boolean expResult = true;
        boolean result = instance.doubleX(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of caughtSpeeding method, of class Testables.
     */
    @Test
    public void testCaughtSpeeding() {
        System.out.println("caughtSpeeding");
        int speed = 60;
        boolean isBirthday = false;
        Testables instance = new Testables();
        int expResult = 0;
        int result = instance.caughtSpeeding(speed, isBirthday);
        assertEquals(expResult, result);
    }
    @Test
    public void testCaughtSpeeding2() {
        System.out.println("caughtSpeeding");
        int speed = 65;
        boolean isBirthday = false;
        Testables instance = new Testables();
        int expResult = 1;
        int result = instance.caughtSpeeding(speed, isBirthday);
        assertEquals(expResult, result);
    }
    @Test
    public void testCaughtSpeeding3() {
        System.out.println("caughtSpeeding");
        int speed = 65;
        boolean isBirthday = true;
        Testables instance = new Testables();
        int expResult = 0;
        int result = instance.caughtSpeeding(speed, isBirthday);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertWord method, of class Testables.
     */
    @Test
    public void testInsertWord() {
        System.out.println("insertWord");
        String container = "<<>>";
        String word = "Yay";
        Testables instance = new Testables();
        String expResult = "<<Yay>>";
        String result = instance.insertWord(container, word);
        assertEquals(expResult, result);
    }
//    @Test
//    public void testInsertWord2() {
//        System.out.println("insertWord");
//        String container = "<<>>";
//        String word = "WooHoo";
//        Testables instance = new Testables();
//        String expResult = "<<Woohoo>>";
//        String result = instance.insertWord(container, word);
//        assertEquals(expResult, result);
//    }
    @Test
    public void testInsertWord3() {
        System.out.println("insertWord");
        String container = "[[]]";
        String word = "word";
        Testables instance = new Testables();
        String expResult = "[[word]]";
        String result = instance.insertWord(container, word);
        assertEquals(expResult, result);
    }

    /**
     * Test of everyOther method, of class Testables.
     */
    @Test
    public void testEveryOther() {
        System.out.println("everyOther");
        String str = "Hello";
        Testables instance = new Testables();
        String expResult = "Hlo";
        String result = instance.everyOther(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testEveryOther2() {
        System.out.println("everyOther");
        String str = "Hi";
        Testables instance = new Testables();
        String expResult = "H";
        String result = instance.everyOther(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testEveryOther3() {
        System.out.println("everyOther");
        String str = "Heeololeo";
        Testables instance = new Testables();
        String expResult = "Hello";
        String result = instance.everyOther(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of multipleEndings method, of class Testables.
     */
    @Test
    public void testMultipleEndings() {
        System.out.println("multipleEndings");
        String str = "Hello";
        Testables instance = new Testables();
        String expResult = "lololo";
        String result = instance.multipleEndings(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultipleEndings2() {
        System.out.println("multipleEndings");
        String str = "ab";
        Testables instance = new Testables();
        String expResult = "ababab";
        String result = instance.multipleEndings(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultipleEndings3() {
        System.out.println("multipleEndings");
        String str = "Hi";
        Testables instance = new Testables();
        String expResult = "HiHiHi";
        String result = instance.multipleEndings(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of skipSum method, of class Testables.
     */
    @Test
    public void testSkipSum() {
        System.out.println("skipSum");
        int a = 3;
        int b = 4;
        Testables instance = new Testables();
        int expResult = 7;
        int result = instance.skipSum(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testSkipSum2() {
        System.out.println("skipSum");
        int a = 9;
        int b = 4;
        Testables instance = new Testables();
        int expResult = 20;
        int result = instance.skipSum(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testSkipSum3() {
        System.out.println("skipSum");
        int a = 10;
        int b = 11;
        Testables instance = new Testables();
        int expResult = 21;
        int result = instance.skipSum(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of sum method, of class Testables.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        int[] numbers = {1,2,3};
        Testables instance = new Testables();
        int expResult = 6;
        int result = instance.sum(numbers);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum2() {
        System.out.println("sum");
        int[] numbers = {5,11,2};
        Testables instance = new Testables();
        int expResult = 18;
        int result = instance.sum(numbers);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum3() {
        System.out.println("sum");
        int[] numbers = {7,0,0};
        Testables instance = new Testables();
        int expResult = 7;
        int result = instance.sum(numbers);
        assertEquals(expResult, result);
    }

    /**
     * Test of alarmClock method, of class Testables.
     */
    @Test
    public void testAlarmClockSundayNoVacationReturns10OClock() {
        System.out.println("alarmClock");
        int day = 0;
        boolean vacation = false;
        Testables instance = new Testables();
        String expResult = "10:00";
        String result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result);
    }
    @Test
    public void testAlarmClockSundayVacationReturnsOff() {
        System.out.println("alarmClock");
        int day = 0;
        boolean vacation = true;
        Testables instance = new Testables();
        String expResult = "off";
        String result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result.toLowerCase());
    }
    @Test
    public void testAlarmClockSaturdayVacationReturnsOff() {
        System.out.println("alarmClock");
        int day = 6;
        boolean vacation = true;
        Testables instance = new Testables();
        String expResult = "off";
        String result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result.toLowerCase());
    }
    @Test
    public void testAlarmClockMondayNoVacationReturns7OClock() {
        System.out.println("alarmClock");
        int day = 1;
        boolean vacation = false;
        Testables instance = new Testables();
        String expResult = "7:00";
        String result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result);
    }
    @Test
    public void testAlarmClockMondayVacationReturns10OClock() {
        System.out.println("alarmClock");
        int day = 1;
        boolean vacation = true;
        Testables instance = new Testables();
        String expResult = "10:00";
        String result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result);
    }
    @Test
    public void testAlarmClockFridayNoVacationReturns7OClock() {
        System.out.println("alarmClock");
        int day = 5;
        boolean vacation = false;
        Testables instance = new Testables();
        String expResult = "7:00";
        String result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result);
    }
    @Test
    public void testAlarmClockFridayVacationReturns10OClock() {
        System.out.println("alarmClock");
        int day = 5;
        boolean vacation = true;
        Testables instance = new Testables();
        String expResult = "10:00";
        String result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result);
    }
    @Test
    public void testAlarmClockDay7IsVacationVacationReturnsInvalid() {
        System.out.println("alarmClock");
        int day = 7;
        boolean vacation = true;
        Testables instance = new Testables();
        String expResult = "day invalid.";
        String result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result.toLowerCase());
    }
    @Test
    public void testAlarmClockDayNeg1IsVacationVacationReturnsInvalid() {
        System.out.println("alarmClock");
        int day = -1;
        boolean vacation = true;
        Testables instance = new Testables();
        String expResult = "day invalid.";
        String result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result.toLowerCase());
    }
    /**
     * Test of firstHalf method, of class Testables.
     */
    @Test
    public void testFirstHalfabcdef() {
        System.out.println("firstHalf");
        String str = "abcdef";
        Testables instance = new Testables();
        String expResult = "abc";
        String result = instance.firstHalf(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testFirstHalfwoohoo() {
        System.out.println("firstHalf");
        String str = "woohoo";
        Testables instance = new Testables();
        String expResult = "woo";
        String result = instance.firstHalf(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testFirstHalfHelloThere() {
        System.out.println("firstHalf");
        String str = "HelloThere";
        Testables instance = new Testables();
        String expResult = "Hello";
        String result = instance.firstHalf(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testFirstHalfHello() {
        System.out.println("firstHalf");
        String str = "Hello";
        Testables instance = new Testables();
        String expResult = "Hel";
        String result = instance.firstHalf(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of makes10 method, of class Testables.
     */
    @Test
    public void testMakes10OneNineSums10() {
        System.out.println("makes10");
        int a = 1;
        int b = 9;
        Testables instance = new Testables();
        boolean expResult = true;
        boolean result = instance.makes10(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testMakes10OneTenSecondValueIsTen() {
        System.out.println("makes10");
        int a = 1;
        int b = 10;
        Testables instance = new Testables();
        boolean expResult = true;
        boolean result = instance.makes10(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testMakes10TenTwoFirstValueIsTen() {
        System.out.println("makes10");
        int a = 10;
        int b = 2;
        Testables instance = new Testables();
        boolean expResult = true;
        boolean result = instance.makes10(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testMakesFourFiveNoValueIsTenSumIsNotTen() {
        System.out.println("makes10");
        int a = 6;
        int b = 6;
        Testables instance = new Testables();
        boolean expResult = false;
        boolean result = instance.makes10(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of rotateLeft method, of class Testables.
     */
    @Test
    public void testRotateLeft123Returns231() {
        System.out.println("rotateLeft");
        int[] numbers = {1, 2, 3};
        Testables instance = new Testables();
        int[] expResult = {2,3,1};
        int[] result = instance.rotateLeft(numbers);
        assertArrayEquals(expResult, result);
    }
    @Test
    public void testRotateLeft5119Returns1195() {
        System.out.println("rotateLeft");
        int[] numbers = {5,11,9};
        Testables instance = new Testables();
        int[] expResult = {11,9,5};
        int[] result = instance.rotateLeft(numbers);
        assertArrayEquals(expResult, result);
    }
    @Test
    public void testRotateLeft123456Returns234561() {
        System.out.println("rotateLeft");
        int[] numbers = {1,2,3,4,5,6};
        Testables instance = new Testables();
        int[] expResult = {2,3,4,5,6,1};
        int[] result = instance.rotateLeft(numbers);
        assertArrayEquals(expResult, result);
    }
    @Test
    public void testRotateLeft123456AndRotationNeg2Returns561234() {
        System.out.println("rotateLeft");
        int[] numbers = {1,2,3,4,5,6};
        Testables instance = new Testables();
        int[] expResult = {5,6,1,2,3,4};
        int[] result = instance.rotateLeft(numbers, -2);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of stringSplosion method, of class Testables.
     */
    @Test
    public void testStringSplosion() {
        System.out.println("stringSplosion");
        String str = "Code";
        Testables instance = new Testables();
        String expResult = "CCoCodCode";
        String result = instance.stringSplosion(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testStringSplosion2() {
        System.out.println("stringSplosion");
        String str = "abc";
        Testables instance = new Testables();
        String expResult = "aababc";
        String result = instance.stringSplosion(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testStringSplosion3() {
        System.out.println("stringSplosion");
        String str = "ab";
        Testables instance = new Testables();
        String expResult = "aab";
        String result = instance.stringSplosion(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of nearHundred method, of class Testables.
     */
    @Test
    public void testNearHundred() {
        System.out.println("nearHundred");
        int n = 89;
        Testables instance = new Testables();
        boolean expResult = false;
        boolean result = instance.nearHundred(n);
        assertEquals(expResult, result);
    }
    @Test
    public void testNearHundred2() {
        System.out.println("nearHundred");
        int n = 103;
        Testables instance = new Testables();
        boolean expResult = true;
        boolean result = instance.nearHundred(n);
        assertEquals(expResult, result);
    }
    @Test
    public void testNearHundred3() {
        System.out.println("nearHundred");
        int n = 90;
        Testables instance = new Testables();
        boolean expResult = true;
        boolean result = instance.nearHundred(n);
        assertEquals(expResult, result);
    }
    @Test
    public void testNearHundred4() {
        System.out.println("nearHundred");
        int n = 190;
        Testables instance = new Testables();
        boolean expResult = true;
        boolean result = instance.nearHundred(n);
        assertEquals(expResult, result);
    }
    @Test
    public void testNearHundred5() {
        System.out.println("nearHundred");
        int n = 203;
        Testables instance = new Testables();
        boolean expResult = true;
        boolean result = instance.nearHundred(n);
        assertEquals(expResult, result);
    }
    @Test
    public void testNearHundred6() {
        System.out.println("nearHundred");
        int n = 211;
        Testables instance = new Testables();
        boolean expResult = false;
        boolean result = instance.nearHundred(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of trimOne method, of class Testables.
     */
    @Test
    public void testTrimOne() {
        System.out.println("trimOne");
        String str = "Hello";
        Testables instance = new Testables();
        String expResult = "ell";
        String result = instance.trimOne(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testTrimOne2() {
        System.out.println("trimOne");
        String str = "coding";
        Testables instance = new Testables();
        String expResult = "odin";
        String result = instance.trimOne(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testTrimOne3() {
        System.out.println("trimOne");
        String str = "java";
        Testables instance = new Testables();
        String expResult = "av";
        String result = instance.trimOne(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testTrim1() {
        System.out.println("trimOne");
        String str = "Hello";
        Testables instance = new Testables();
        String expResult = "l";
        String result = instance.trim(str, 2);
        assertEquals(expResult, result);
    }
    @Test
    public void testTrim2() {
        System.out.println("trimOne");
        String str = "Hell";
        Testables instance = new Testables();
        String expResult = "";
        String result = instance.trim(str, 2);
        assertEquals(expResult, result);
    }
    @Test
    public void testTrim3() {
        System.out.println("trimOne");
        String str = "Hel";
        Testables instance = new Testables();
        String expResult = "";
        String result = instance.trim(str, 2);
        assertEquals(expResult, result);
    }
    @Test
    public void testTrimr() {
        System.out.println("trimOne");
        String str = "HelloTom";
        Testables instance = new Testables();
        String expResult = "lo";
        String result = instance.trim(str, 3);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of longInMiddle method, of class Testables.
//     */
//    @Test
//    public void testLongInMiddle() {
//        System.out.println("longInMiddle");
//        String a = "";
//        String b = "";
//        Testables instance = new Testables();
//        String expResult = "";
//        String result = instance.longInMiddle(a, b);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of posNeg method, of class Testables.
//     */
//    @Test
//    public void testPosNeg() {
//        System.out.println("posNeg");
//        int a = 0;
//        int b = 0;
//        boolean negative = false;
//        Testables instance = new Testables();
//        boolean expResult = false;
//        boolean result = instance.posNeg(a, b, negative);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
