package com.sg.pangrams;

import java.util.HashMap;
import java.util.Map;

public class Pangram {

    private Map<Character, Boolean> map;
    
    public boolean isPangram(String potentialPangram) {
        
        map = new HashMap<>(){{
            put('A', false);
            put('B', false);
            put('C', false);
            put('D', false);
            put('E', false);
            put('F', false);
            put('G', false);
            put('H', false);
            put('I', false);
            put('J', false);
            put('K', false);
            put('L', false);
            put('M', false);
            put('N', false);
            put('O', false);
            put('P', false);
            put('Q', false);
            put('R', false);
            put('S', false);
            put('T', false);
            put('U', false);
            put('V', false);
            put('W', false);
            put('X', false);
            put('Y', false);
            put('Z', false);
        }};
        potentialPangram = potentialPangram.toUpperCase();
        
        boolean isValid = potentialPangram.matches("[A-Za-z]+");
        if(isValid){
            char[] chars = potentialPangram.toCharArray();
            int totalTrues = 0;
            for (char aChar : chars) {
                if(!map.get(aChar)){
                    map.put(aChar, true);
                    totalTrues++;
                }
            }
            return totalTrues == 26;
        }
        return false;
    }
}
