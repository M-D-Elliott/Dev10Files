package Challenges;

import java.util.Scanner;

public class StringChallenges {
    private Scanner sc = new Scanner(System.in);
    private boolean _continue = true;
    
    private String[] _options = fillOptions();
    private String _banner = "*-".repeat(30);
    public void run() {
        fillOptions();
        while(_continue) {
            printBanner();
            System.out.println("'M' or 'Methods' for method list.\n'Q' or 'quit' to quit.");
            printBanner();
            String methodName = readInput("Enter the method name:");
            if(methodName.equalsIgnoreCase("q") || methodName.equalsIgnoreCase("quit")){
                _continue = false;
                break;
            } else if (methodName.equalsIgnoreCase("methods") || methodName.equalsIgnoreCase("m")) {
                System.out.println("");
                printBanner();
                printArray(_options);
                System.out.println("");
            } else if(methodName.equals("")) {
                System.out.println("Sorry, I didnt' get that!");
            }else {
                String value = readInput("Enter the string to work on.");
                String s = pickMethod(methodName.toLowerCase(), value);
                
                System.out.println("");
                System.out.println("Here you are!");
                printBanner();
                System.out.println(s);
                printBanner();
                System.out.println("");
            }

        }

    }
    
    public String pickMethod(String methodName, String value) {
        String ret = value;
        int n = 0;
        switch(methodName) {
            case "timestwo":
                ret = timesTwo(value);
                break;
            case "repeat":
                n = readIntInput("How many times to repeat?");
                ret = value.repeat(n);
                break;
            case "countvowels":
                ret = Integer.toString(countVowels(value));
                break;
            case "hasdayfirst":
                ret = Boolean.toString(hasDayFirst(value));
                break;
            case "hasdayeither":
                ret = Boolean.toString(hasDayEither(value));
                break;
            case "encloseintag":
                String tag = readInput("What is the tag?");
                ret = encloseInTag(value, tag);
                break;
            case "lastcharfirst":
                ret = lastCharFirst(value);
                break;
            case "lastncharsfirst":
                n = readIntInput("How many chars?");
                ret = lastNCharsFirst(value, n);
                break;
            case "stringisnice":
                ret = Boolean.toString(stringContains(value, "nice"));
                break;
            case "firstandlastcharsremoved":
                ret = firstAndLastCharsRemoved(value);
                break;
            case "middle":
                ret = middleChar(value);
                break;
            case "doublechars":
                ret = doubleChars(value);
                break;
            case "interleave":
                String s = readInput("I need a second string");
                ret = interleave(value, s);
                break;
            case "lasttwocharsequal":
                ret = Boolean.toString(lastNCharsEqual(value, 2));
                break;
            case "lastncharsequal":
                n = readIntInput("How many chars?");
                ret = Boolean.toString(lastNCharsEqual(value, n));
                break;
            default:
                ret = "No method of that name!";
                break;
        }
        return ret;
    }
    
    public String timesTwo(String value) {
        return value + value;
    }
    
    public int countVowels(String s) {
        int count = 0;
        for(char ch : s.toCharArray()) {
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y'){
                count++;
            }
        }
        return count;
    }
    
    public boolean hasDayFirst(String s) {
        s += "   ";
        String first3 = s.substring(0, 3);
        String first4 = s.substring(0, 5);
        if(first3.equalsIgnoreCase("mon") ||
           first4.equalsIgnoreCase("tues") ||
           first4.equalsIgnoreCase("weds") ||
           first4.equalsIgnoreCase("thur") ||
           first3.equalsIgnoreCase("fri") ||
           first3.equalsIgnoreCase("sat") ||
           first3.equalsIgnoreCase("sun"))
        {
            return true;
        }
        return false;
    }
    
    public boolean hasDayLast(String s) {
        int len = s.length();
        s += "   ";
        String last3 = s.substring(len - 3, len);
        String last4 = s.substring(len - 4, len);
        if(last3.equalsIgnoreCase("mon") ||
           last4.equalsIgnoreCase("tues") ||
           last4.equalsIgnoreCase("weds") ||
           last4.equalsIgnoreCase("thur") ||
           last3.equalsIgnoreCase("fri") ||
           last3.equalsIgnoreCase("sat") ||
           last3.equalsIgnoreCase("sun"))
        {
            return true;
        }
        return false;
    }
    
    public boolean hasDayEither(String s) {
        return hasDayFirst(s) || hasDayLast(s);
    }
    
    public String removeNumbers(String s) {
        return s.replaceAll("\\d","");
    }
    
    public String encloseInTag(String s, String tag) {
        return "<" + tag + ">" + s + "<" + tag + "/>";
    }
    
    public String lastCharFirst(String s) {
        return lastNCharsFirst(s, 1);
    }
    
    public String lastNCharsFirst(String s, int n) {
        int len = s.length();
        return s.substring(len - (n), len) + s.substring(0, len - n);
    }
    
    public boolean stringContains(String s, String sub) {
        return s.toLowerCase().contains(sub.toLowerCase());
    }
    
    public String firstAndLastChars(String s) {
        int len = s.length();
        if(len == 1) {
            return s + s;
        }
        return s.substring(0, 1) + s.substring(len - 2, len -1);
    }
    
    public String firstAndLastCharsRemoved(String s) {
        int len = s.length();
        if(len == 1) {
            return "";
        }
        return s.substring(1, len - 1);
    }
    
    public String middleChar(String s) {
        int len = s.length();
        if(len % 2 == 0){
            return "";
        }
        int middle = Math.round(len / 2);
        return s.substring(middle, middle + 1);
    }
    
    public String doubleChars(String s) {
       String ret = "";
       for(char ch : s.toCharArray()) {
           ret += Character.toString(ch) + Character.toString(ch);
       }
       return ret;
    }
    
    public String interleave(String s, String s2){
        return s + s2;
    }
    
    public boolean lastNCharsEqual(String s, int n){
        int len = s.length();
        if(len <= n) {
            return false;
        } else {
            String lastNChars = s.substring(len - n, len);
            return allCharsEqual(lastNChars);
        }
    }
    
    public boolean allCharsEqual(String s) {
        int len = s.length();
        String first = s.substring(0, 1);
        
        for(char ch : s.toCharArray()) {
            if (!first.equals(ch)){
                return false;
            }
        }
        return true;
    }
    
    public String readInput(String prompt) {
        System.out.println(prompt + " ");
        return sc.nextLine();
    }
    
    public int readIntInput(String prompt) {
        System.out.println(prompt + " ");
        return sc.nextInt();
    }

    private String[] fillOptions() {
        return new String[] {
        "timesTwo",
        "repeat",
        "countVowels",
        "hasDayFirst",
        "hasDayEither",
        "encloseInTag",
        "lastCharFirst",
        "lastNCharsFirst",
        "stringIsNice",
        "firstAndLastCharsRemoved",
        "middle",
        "doubleChars",
        "interleave",
        "lastTwoCharsEqual",
        "lastNCharsEqual",
        };
    }

    private void printArray(String[] array) {
        int len = array.length;
        for(int i = 0; i < len; i++) {
            System.out.println(i + 1 + ". " + array[i]);
        }
    }
    
    private void printBanner() {
        System.out.println(_banner);
    }
}
