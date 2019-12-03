package com.sg.calculatorv4.Utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class StringUtils {
    private StringUtils(){}
    /**
    * Returns a string, s, and an int, n.If the int n is anything
 but 1 the string will be returned with an s appended to it.<p>This method is very helpful for console IO, or MVC. Try it out!
    * <pre>
    *
    *
     * @param s
     * @param n
    **/
    public static final String pluralize(String s, int n) {
        return pluralize(s, n, "s");
    }
    
    public static final String pluralize(String s, int n, String attachment) {
        return (n == 1) ? s : s + attachment;
    }
    
    public static final String removeNumbers(String s) {
        return s.replaceAll("\\d","");
    }
    
    public static final String encloseInTag(String s, String tag) {
        return "<" + tag + ">" + s + "<" + tag + "/>";
    }
    
    public static final String lastCharFirst(String s) {
        return lastNCharsFirst(s, 1);
    }
    
    public static final String lastNCharsFirst(String s, int n) {
        int len = s.length();
        return s.substring(len - (n), len) + s.substring(0, len - n);
    }
    
    public static final boolean stringContains(String s, String sub) {
        return s.toLowerCase().contains(sub.toLowerCase());
    }
    
    public static final String firstAndLastChars(String s) {
        int len = s.length();
        if(len == 1) {
            return s + s;
        }
        return s.substring(0, 1) + s.substring(len - 2, len -1);
    }
    
    public static final String firstAndLastCharsRemoved(String s) {
        int len = s.length();
        if(len == 1) {
            return "";
        }
        return s.substring(1, len - 1);
    }
    
    public static final String middleChar(String s) {
        int len = s.length();
        if(len % 2 == 0){
            return "";
        }
        int middle = Math.round(len / 2);
        return s.substring(middle, middle + 1);
    }
    
    public static final String doubleChars(String s) {
       String ret = "";
       for(char ch : s.toCharArray()) {
           ret += Character.toString(ch) + Character.toString(ch);
       }
       return ret;
    }
    
    public static final String interleave(String s, String s2){
        return s + s2;
    }
    
    public static final boolean lastNCharsEqual(String s, int n){
        int len = s.length();
        if(len <= n) {
            return false;
        } else {
            String lastNChars = s.substring(len - n, len);
            return allCharsEqual(lastNChars);
        }
    }
    
    public static final boolean allCharsEqual(String s) {
        int len = s.length();
        String first = s.substring(0, 1);
        
        for(char ch : s.toCharArray()) {
            if (!first.equals(ch)){
                return false;
            }
        }
        return true;
    }
    
    public static final String arrayToString(String[][] array){
        return Arrays
            .stream(array)
            .map(Arrays::toString) 
            .collect(Collectors.joining(System.lineSeparator()));
    }
    
    public static final String reverse(String s) {
        String[] inArray = s.split("");
        String reversed = "";
        for(int i =inArray.length - 1;i>=0;i--){
            reversed += inArray[i];
        }
        return reversed;
    }
    
    public static final String crunch(String s) {
        return s.replaceAll("\\s+","");
    }
    
    
    // not mine
    public static final String removePunctuation(String s) {
        String res = "";
        for (Character c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c))
                res += c;
        }
        return res;
    }
    
    public static final boolean isPalindrome(String s){
        s = crunch(s);
        s = s.toLowerCase();
        s = removePunctuation(s);
        
        int len = s.length();
        int half = IntUtils.getHalf(len, 1);
        String s1 = s.substring(0, half);
        String s2 = reverse(s.substring(half - 1, len));
        return (s1 == null ? s2 == null : s1.equals(s2));
    }
    
    public static final boolean equalsAny(String s, String... args){
        return Arrays.asList(args).contains(s.toLowerCase());
    }
}
