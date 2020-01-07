package com.sg.romannumerals.objects;

import java.util.ArrayList;
import java.util.List;

public class Numerals {

    public void run(){
        List<String> list = new ArrayList<>(){{
            add("XI");
            add("VI");
            add("CCI");
            add("MMMMMMMMMMMI");
            add("MMXVIII");
        }};
        for (String s : list) {
            System.out.println(romanToNumeral(s));;
        }

    }

    private int romanToNumeral(String s) {
        int length = s.length();
        
        int returnInt = 0;
        
        if(length > 2){
            for (int i = 1; i < s.length() - 2;) {
                char prevChar = s.charAt(i - 1);
                char currentChar = s.charAt(i);
                int firstSlot = numeralSwitch(prevChar);
                int secondSlot = numeralSwitch(currentChar);
                if(firstSlot == 1 && secondSlot != 1){
                    returnInt += secondSlot - firstSlot;
                    i += 2;
                } else if(firstSlot != 1 && secondSlot == 1){
                    char nextChar  = s.charAt(i + 1);
                    if(nextChar == 'I'){
                        returnInt += firstSlot + secondSlot;
                        i += 2;
                    } else {
                        returnInt += firstSlot;
                        i++;
                    }
                } else {
                    returnInt += firstSlot + secondSlot;
                    i += 2;
                }
            }
        } else if(length == 2){
            char prevChar = s.charAt(0);
            char currentChar = s.charAt(1);
            int firstSlot = numeralSwitch(prevChar);
            int secondSlot = numeralSwitch(currentChar);
            
            if(firstSlot == 1 && secondSlot != 1){
                returnInt += secondSlot - firstSlot;
            }  else {
                returnInt += firstSlot + secondSlot;
            }
        } else if(length == 1){
            returnInt = numeralSwitch(s.charAt(0));
        }
        return returnInt;
    }

    
    private int numeralSwitch(char c){
        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
