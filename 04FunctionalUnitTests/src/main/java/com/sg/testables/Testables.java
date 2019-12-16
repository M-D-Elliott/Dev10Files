package com.sg.testables;

import java.util.Arrays;

public class Testables {
    // Given 2 arrays of ints, a and b, return true if they 
    // have the same first element or they have the same 
    // last element. Both arrays will be length 1 or more. 
    //
    // commonEnd({1, 2, 3}, {7, 3}) -> true
    // commonEnd({1, 2, 3}, {7, 3, 2}) -> false
    // commonEnd({1, 2, 3}, {1, 3}) -> true
    public boolean commonEnd(int[] a, int[] b) {
        return a[0] == b[0] || a[a.length - 1] == b[b.length - 1];
    }
    
    // Given a String, return true if the first instance 
    // of "x" in the String is immediately followed by 
    // another "x". 
    //
    // doubleX("axxbb") -> true
    // doubleX("axaxxax") -> false
    // doubleX("xxxxx") -> true
    public boolean doubleX(String str) {
        int index = 0;
        for (char c : str.toCharArray()) {
            if(index + 1 < str.length() && c == str.charAt(index + 1)){
                return true;
            }
            index++;
        }
        return false;
    }
    
    // You are driving a little too fast, and a police 
    // officer stops you. Write code to compute the 
    // result, encoded as an int value: 0=no ticket, 
    // 1=small ticket, 2=big ticket. If speed is 60 or 
    // less, the result is 0. If speed is between 61 
    // and 80 inclusive, the result is 1. If speed is 
    // 81 or more, the result is 2. Unless it is your 
    // birthday -- on that day, your speed can be 5 
    // higher in all cases. 
    //
    // caughtSpeeding(60, false) → 0
    // caughtSpeeding(65, false) → 1
    //caughtSpeeding(65, true) → 0
    public int caughtSpeeding(int speed, boolean isBirthday) {
        int add = (isBirthday) ? -5 : 0;
        int total = speed + add;
        return (total <= 60) ? 0 : (total <= 80) ? 1 : 2;
    }
    // Given an "out" String length 4, such as "<<>>", and a 
    // word, return a new String where the word is in the middle 
    // of the out String, e.g. "<<word>>".
    //
    // Hint: SubStrings are your friend here 
    //
    // insertWord("<<>>", "Yay") -> "<<Yay>>"
    // insertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
    // insertWord("[[]]", "word") -> "[[word]]"
    public String insertWord(String container, String word) {
        return container.substring(0, 2) + word + container.substring(container.length() - 2);
    }
    // Given a String, return a new String made of every other 
    // char starting with the first, so "Hello" yields "Hlo". 
    //
    // everyOther("Hello") -> "Hlo"
    // everyOther("Hi") -> "H"
    // everyOther("Heeololeo") -> "Hello"
    public String everyOther(String str) {
        String ret = "";
        int index = 1;
        for (char c : str.toCharArray()) {
            if(index == 1){
                ret += c;
            }
            index = -index;
        }
        return ret;
    }
    // Given a String, return a new String made of 3 copies 
    // of the last 2 chars of the original String. The String 
    // length will be at least 2. 
    //
    // multipleEndings("Hello") -> "lololo"
    // multipleEndings("ab") -> "ababab"
    // multipleEndings("Hi") -> "HiHiHi"
    public String multipleEndings(String str) {
        int length = str.length();
        return str.substring(length -2).repeat(3);
    }
    // Given 2 ints, a and b, return their sum. However, sums 
    // in the range 10..19 inclusive are forbidden, so in that case just return 20. 
    //
    // skipSum(3, 4) → 7
    // skipSum(9, 4) → 20
    // skipSum(10, 11) → 21
    public int skipSum(int a, int b) {
        int sum = a + b;
        return (sum >= 10 && sum <= 19) ? 20 : sum;
    }
    // Given an array of ints, return the sum of all the elements. 
    //
    // sum({1, 2, 3}) -> 6
    // sum({5, 11, 2}) -> 18
    // sum({7, 0, 0}) -> 7
    public int sum(int[] numbers) {
        int ret = 0;
        for (int number : numbers) {
            ret += number;
        }
        return ret;
    }
	    // Given a day of the week encoded as 
    // 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating 
    // if we are on vacation, return a String of the form "7:00" 
    // indicating when the alarm clock should ring. Weekdays, the 
    // alarm should be "7:00" and on the weekend it should be "10:00". 
    // Unless we are on vacation -- then on weekdays it should be 
    // “10:00" and weekends it should be "off". 
    //
    // alarmClock(1, false) → "7:00"
    // alarmClock(5, false) → "7:00"
    // alarmClock(0, false) → "10:00"
    public String alarmClock(int day, boolean vacation) {
        if(day < 6 && day > 0){
            if(vacation){
                return "10:00";
            } else {
                return "7:00";
            }
        } else if(day == 0 || day == 6) {
            if(vacation){
                return "off";
            } else {
                return "10:00";
            }
        }
        return "Day invalid.";
    }
    // Given a String of even length, return the first half. 
    // So the String "WooHoo" yields "Woo". 
    //
    // firstHalf("WooHoo") -> "Woo"
    // firstHalf("HelloThere") -> "Hello"
    // firstHalf("abcdef") -> "abc"
    public String firstHalf(String str) {
        int length = str.length();
        
        boolean isEven = length % 2 == 0;
        
        int adj = (isEven) ? 0 : 1;
        
        int halfIndex = (int)(length / 2) + adj;
        
        return str.substring(0, halfIndex);
    }
	
    // Given two ints, a and b, return true if one if them is 10 
    // or if their sum is 10. 
    //
    // makes10(9, 10) -> true
    // makes10(9, 9) -> false
    // makes10(1, 9) -> true
    public boolean makes10(int a, int b) {
        return a == 10 || b == 10 || a + b == 10;
    }
	
    // Given an array of ints, return an array with the elements 
    // “rotated left" so {1, 2, 3} yields {2, 3, 1}. 
    //
    // rotateLeft({1, 2, 3}) -> {2, 3, 1}
    // rotateLeft({5, 11, 9}) -> {11, 9, 5}
    // rotateLeft({7, 0, 0}) -> {0, 0, 7}
//    {1, 2, 3, 4, 5, 6}
    public int[] rotateLeft(int[] numbers) {
        return rotateLeft(numbers, 1);
    }
    public int[] rotateLeft(int[] numbers, int rotation) {
        int length = numbers.length;
        int remainder = rotation % length;
        int reducedRotation = (remainder == 0) ? 0 : remainder;
        if(reducedRotation != 0){
            int[] retArray = new int[length];
            for (int i = 0; i < length; i++) {
                int appendIndex = i - reducedRotation;
                appendIndex = (appendIndex < 0) ? length + appendIndex : (appendIndex >= length) ? -(length - appendIndex) : appendIndex;
                retArray[appendIndex] = numbers[i]; 
            }
            return retArray;
        }
        return numbers;
    }
	
    // Given a non-empty String like "Code" return a String like 
    // “CCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
    public String stringSplosion(String str) {
        String ret = "";
        for (int i = 0; i < str.length(); i++) {
            ret += str.substring(0, i + 1);
        }
        return ret;
    }
    
    // Given an int n, return true if it is within 10 of 100 
    // or 200.
    // Hint: Check out the Math class for absolute value
    //
    // nearHundred(103) -> true
    // nearHundred(90) -> true
    // nearHundred(89) -> false
    public boolean nearHundred(int n) {
        return ((n > 100 && n % 100 < 10) || n % 100 > 89);
    }

    
    // Given a String, return a version without the first and 
    // last char, so "Hello" yields "ell". The String length will be at least 2. 
    //
    // trimOne("Hello") -> "ell"
    // trimOne("java") -> "av"
    // trimOne("coding") -> "odin"
    public String trimOne(String str) {
        return trim(str, 1);
    }

    public String trim(String str, int reduction){
        int length = str.length();
        int doubleReduction = reduction * 2;
        if(length > doubleReduction){
            return str.substring(reduction, length - reduction);
        } else {
            return "";
        }
    }
    
    // Given 2 Strings, a and b, return a String of the form 
    // short+long+short, with the shorter String on the outside 
    // and the longer String on the inside. The Strings will not 
    // be the same length, but they may be empty (length 0). 
    //
    // longInMiddle("Hello", "hi") -> "hiHellohi"
    // longInMiddle("hi", "Hello") -> "hiHellohi"
    // longInMiddle("aaa", "b") -> "baaab"
    public String longInMiddle(String a, String b) {
        throw new UnsupportedOperationException("Not implemented");
    }

    
    // Given two int values, return true if one is negative and 
    // one is positive. Except if the parameter "negative" is 
    // true, then return true only if both are negative. 
    //
    // posNeg(1, -1, false) -> true
    // posNeg(-1, 1, false) -> true
    // posNeg(-4, -5, true) -> true
    public boolean posNeg(int a, int b, boolean negative) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
