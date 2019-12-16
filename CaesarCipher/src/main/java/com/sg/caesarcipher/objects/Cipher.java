package com.sg.caesarcipher.objects;

import java.util.ArrayList;
import java.util.List;

public class Cipher {
//    private List<Character> letterList;
    
    private int frameShift = 5;

    public Cipher() {
    }
    
//RSA Algo.
    public String encrypt(String message){
        message = encrypt(message, frameShift);
        return message;
    }
    
    private String encrypt(String message, int frameShift){
        String ret = "";
        for (Character c : message.toUpperCase().toCharArray()) {
            if(Character.isWhitespace(c)){
                ret += " ";
            } else {
                ret += (char)(((c + frameShift - 65) % 26) + 65);
            }
        }
        return ret;
    }
    
    public String decrypt(String message){
        message = decrypt(message, frameShift);
        return message;
    }
    private String decrypt(String message, int frameShift){
        String ret = "";
        for (Character c : message.toUpperCase().toCharArray()) {
            if(Character.isWhitespace(c)){
                ret += " ";
            } else {
                int total = c - 65 - frameShift;
                if(total < 0){
                    total = 26 + total;
                }
                ret += (char)(((total) % 26) + 65);
            }

        }
        return ret;
    }  
    
    public int shift(int value, int length){
        return value % length;
    }
    
    public void bruteForce(String message){
        for(int i = 0; i < 26; i++){
            System.out.println(i + ". " + decrypt(message, i));
        }
    }
}
