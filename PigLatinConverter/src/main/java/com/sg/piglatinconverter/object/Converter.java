package com.sg.piglatinconverter.object;

public class Converter {
    public String toPigLatin(String str) {
        String[] arrayString = str.split(" ");
        
        String retString = "";
        
        for (String string : arrayString) {
            String appendEnd = "ay";
            String newAppend = "";
            
            boolean foundVowel = false;
            
            String afterVowel = "";
            
            String punc = " ";
            
            for (int i =0; i < string.length(); i++) {
                char c = string.charAt(i);
                if(!Character.isLetter(c)){
                    punc = c + punc;
                } else if(foundVowel || isVowel(c)){
                    afterVowel += c;
                    foundVowel = true;
                    if(i == 0){
                        appendEnd = "yay";
                    } 
                } else {
                    newAppend += c;
                }
            }
            newAppend += appendEnd;
            retString += afterVowel + newAppend + punc;
        }
        return retString.toLowerCase();
    }
    
    private boolean isVowel(char c){
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
    
    private boolean isConsonant(char c){
        return !isVowel(c);
    }

    private boolean isPunctuation(char c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
