package com.sg.unittesting.firstwave;

public class Testables {
    // Given a String and a non-negative int n, return a larger String 
    // that is n copies of the original String. 
    //
    // stringTimes("Hi", 2) -> "HiHi"
    // stringTimes("Hi", 3) -> "HiHiHi"
    // stringTimes("Hi", 1) -> "Hi"
    public String stringTimes(String str, int n) {
        String ret = "";
        for (int i = 0; i < n; i++) {
            ret += str;
        }
        return ret;
    }

        // We have two children, a and b, and the parameters aSmile and 
    // bSmile indicate if each is smiling. We are in trouble if they 
    // are both smiling or if neither of them is smiling. Return true 
    // if we are in trouble. 
    //
    // areWeInTrouble(true, true) -> true
    // areWeInTrouble(false, false) -> true
    // areWeInTrouble(true, false) -> false
    public boolean areWeInTrouble(boolean aSmile, boolean bSmile) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    // Given two Strings, a and b, return the result of putting 
    // them together in the order abba, e.g. "Hi" and "Bye" 
    // returns "HiByeByeHi". 
    //
    // abba("Hi", "Bye") -> "HiByeByeHi"
    // abba("Yo", "Alice") -> "YoAliceAliceYo"
    // abba("What", "Up") -> "WhatUpUpWhat"
    public String abba(String a, String b) {
        return a + b + b + a;
    }
    
    // You and your date are trying to get a table at a restaurant. 
    // The parameter "you" is the stylishness of your clothes, in 
    // the range 0..10, and "date" is the stylishness of your date's 
    // clothes. The result getting the table is encoded as an int 
    // value with 0=no, 1=maybe, 2=yes. If either of you is very stylish, 
    // 8 or more, then the result is 2 (yes). With the exception that if 
    // either of you has style of 2 or less, then the result is 0 (no). 
    // Otherwise the result is 1 (maybe). 
    //
    // canHazTable(5, 10) → 2
    // canHazTable(5, 2) → 0
    // canHazTable(5, 5) → 1
    public int canHazTable(int yourStyle, int dateStyle) {
        if(yourStyle <= 2 || dateStyle <= 2){
            return 0;
        }else if(yourStyle >= 8 || dateStyle >= 8){
            return 2;
        }
        return 1;
    }
    
    // Given a String and a non-negative int n, we'll say that the 
    // front of the String is the first 3 chars, or whatever is there 
    // if the String is less than length 3. Return n copies of the front; 
    //
    // frontTimes("Chocolate", 2) -> "ChoCho"
    // frontTimes("Chocolate", 3) -> "ChoChoCho"
    // frontTimes("Abc", 3) -> "AbcAbcAbc"
    public String frontTimes(String str, int n) {
        if(str.length() > 3){
            return str.substring(0, 3).repeat(n);
        } else {
            return str.repeat(n);
        }
    }
    
    // Given an array of ints, return true if 6 appears as either the 
    // first or last element in the array. The array will be length 1 or more. 
    //
    // firstLast6({1, 2, 6}) -> true
    // firstLast6({6, 1, 2, 3}) -> true
    // firstLast6({13, 6, 1, 2, 3}) -> false
    public boolean firstLast6(int... numbers) {
        int length = numbers.length;
        if(length > 0){
            return numbers[0] == 6 || numbers[length - 1] == 6;
        }
        return false;
    }
    
    // Given an array of ints, return true if the array is length 
    // 1 or more, and the first element and the last element are equal. 
    //
    // sameFirstLast({1, 2, 3}) -> false
    // sameFirstLast({1, 2, 3, 1}) -> true
    // sameFirstLast({1, 2, 1}) -> true
    public boolean sameFirstLast(int... numbers) {
        int length = numbers.length;
        if(length > 0){
            return numbers[0] == numbers[length - 1];
        }
        
        return false;
    }
    
        // The parameter weekday is true if it is a weekday, and the 
    // parameter vacation is true if we are on vacation. We sleep 
    // in if it is not a weekday or we're on vacation. Return true 
    // if we sleep in. 
    //
    // canSleepIn(false, false) -> true
    // canSleepIn(true, false) -> false
    // canSleepIn(false, true) -> true
    public boolean canSleepIn(boolean isWeekday, boolean isVacation) {
        return !isWeekday || isVacation;
    }
    
    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    //
    // countXX("abcxx") -> 1
    // countXX("xxx") -> 2
    // countXX("xxxx") -> 3
    public int countXX(String str) {
        throw new UnsupportedOperationException("Not implemented");
    }

        // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3, 1, 4}

    public int[] makePi(int n) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    // The web is built with HTML Strings like "<i>Yay</i>" which 
    // draws Yay as italic text. In this example, the "i" tag makes 
    // <i> and </i> which surround the word "Yay". Given tag and word 
    // Strings, create the HTML String with tags around the word, e.g. 
    // “<i>Yay</i>". 
    //
    // makeTags("i", "Yay") -> "<i>Yay</i>"
    // makeTags("i", "Hello") -> "<i>Hello</i>"
    // makeTags("cite", "Yay") -> "<cite>Yay</cite>"
    public String makeTags(String tag, String content) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    // The children in Cleveland spend most of the day playing outside. 
    // In particular, they play if the temperature is between 60 and 90 
    // (inclusive). Unless it is summer, then the upper limit is 100 
    // instead of 90. Given an int temperature and a boolean isSummer, 
    // return true if the children play and false otherwise. 
    //
    // playOutside(70, false) → true
    // playOutside(95, false) → false
    // playOutside(95, true) → true
    public boolean playOutside(int temp, boolean isSummer) {
        throw new UnsupportedOperationException("Not implemented");
    }

    // Given two int values, return their sum. However, if the two 
    // values are the same, then return double their sum. 
    //
    // sumDouble(1, 2) -> 3
    // sumDouble(3, 2) -> 5
    // sumDouble(2, 2) -> 8
    public int sumDouble(int a, int b) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    // Given an int n, return the absolute value of the difference 
    // between n and 21, except return double the absolute value 
    // of the difference if n is over 21. 
    //
    // diff21(23) -> 4
    // diff21(10) -> 11
    // diff21(21) -> 0
    public int diff21(int n) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    // We have a loud talking parrot. The "hour" parameter is the 
    // current hour time in the range 0..23. We are in trouble if 
    // the parrot is talking and the hour is before 7 or after 20. 
    // Return true if we are in trouble. 
    //
    // parrotTrouble(true, 6) -> true
    // parrotTrouble(true, 7) -> false
    // parrotTrouble(false, 6) -> false
    public boolean parrotTrouble(boolean isTalking, int hour) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
