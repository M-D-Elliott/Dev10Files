package com.mycompany.advancedcalculatorv3.Utils;

public final class CharUtils {
    private CharUtils(){}
    
    public static final boolean isDigit(char c){
        return (c >= '0' && c <= '9');
    }
    
    public static final String toString(char[] c){
        return "";
    }
    
    public static final String toString(Character[] characters){
        StringBuilder sb = new StringBuilder(); 
  
        // Appends characters one by one 
        for (Character ch : characters) { 
            sb.append(ch); 
        } 

        return sb.toString();
    }
}
