package com.sg.isbnverifier.utils;

public final class IntUtils {

    private IntUtils() {
    }
    
    public static final int getHalf(int value) {
        return getHalf(value, 0);
    }
    
    public static int getHalf(int value, int adjustment) {
        if(isEven(value)){
            adjustment = 0;
        }
        return (int)Math.floor(value / 2) + adjustment;
    }
    
    public static int filter(int value, int min, int max) {
        if(value > max) {
            value = max;
        } else if(value < min) {
            value = min;
        }
        return value;
    }
    
    public static int countDigits(int i){
        return (int) (Math.log10(i) + 1);
    }
    
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }
    
    public static boolean isOdd(int value){
        return !isEven(value);
    }
    
    public static int[] evens(int[] array){
        int total = 0;
        for (int i : array) {
            if(isEven(i)){
                total++;
            }
        }
        
        int index = 0;
        
        int[] ret = new int[total];
        for (int i : array) {
            if(isEven(i)){
                ret[index] = i;
                index++;
            }
        }
        return ret;
    }
    
    public static int[] odds(int[] array){
        int total = 0;
        for (int i : array) {
            if(isOdd(i)){
                total++;
            }
        }
        
        int index = 0;
        
        int[] ret = new int[total];
        for (int i : array) {
            if(isOdd(i)){
                ret[index] = i;
                index++;
            }
        }
        return ret;
    }
    
    public static boolean increasingOrder(int[] array) {
        for (int index = 0; index < array.length; index++) {
            if(index > 0){
                int prev = array[index - 1];
                int curr = array[index];
                if(curr < prev){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean decreasingOrder(int[] array) {
        for (int index = 0; index < array.length; index++) {
            if(index > 0){
                int prev = array[index - 1];
                int curr = array[index];
                if(curr > prev){
                    return false;
                }
            }
        }
        return true;
    }
    
//    public static String isOrder(int[] array, String arg){
//        if(StringUtils.equalsAll(arg, options)){
//        
//        }
//    }
    
    public static boolean isOrder(int[] array, boolean order){
        if(order) {
            return increasingOrder(array);
        } else {
            return decreasingOrder(array);
        }
    }
    
    public static int tryParseInt(char character){
        return tryParseInt(String.valueOf(character));
    }
    
    public static int tryParseInt(String string){
        try{
            return Integer.parseInt(string);
        } catch(NumberFormatException e){
            System.out.println(e);
            System.out.println("No int in supplied string.");
            System.out.println("Returning 0.");
        }
        return 0;
    }
    
    public static int sum(int[] i){
        int sum=0;
        for(int count=0;count<i.length;count++){
            sum+=i[count];
        }
        return sum;
    }
}
