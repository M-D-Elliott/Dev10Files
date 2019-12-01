package Utils;

import java.util.Scanner;

public final class InOutUtils {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String BANNER = "==".repeat(30);
    
    private InOutUtils() {
    }
    
    public static final String readInput(String prompt) {
        System.out.println(prompt + " ");
        return SCANNER.nextLine();
    }
    
    public static final int readInt(String prompt) {
        System.out.println(prompt + " ");
        int ret = SCANNER.nextInt();
        SCANNER.nextLine();
        return ret;
    }
    
        public static final double readDouble(String prompt) {
        System.out.println(prompt + " ");
        double ret = SCANNER.nextDouble();
        SCANNER.nextLine();
        return ret;
    }
    
    public static final boolean readBooleanInput(String prompt) {
        System.out.println(prompt + " ");
        boolean ret = SCANNER.nextBoolean();
        SCANNER.nextLine();
        return ret;
    }
    
    public static final String encaseInBanner(String... args) { 
        return encaseInBanner(BANNER, args);
    }
    
    public static final String encaseInBanner(String banner, String... args) { 
        return encaseInBanner(BANNER, false, false, args);
    }
    
    public static final String encaseInBanner(boolean spacing, String... args) { 
        return encaseInBanner(BANNER, spacing, false, args);
    }
    
    public static final String encaseInBanner(boolean spacing, boolean print, String... args) {
        return encaseInBanner(BANNER, spacing, print, args);
    }
    
    public static final String encaseInBanner(String banner, boolean spacing, boolean print, String... args) {
        // gets extra white space for banner objects if argued.
        String whiteSpace = (spacing) ? "\n" : "";
        
        //sets the init return to just the supplied banner.
        String ret = banner;
        
        //attaches an inital new line to anything under the first banner
        ret += "\n";
        
        for(String arg : args) {
            ret += whiteSpace;
            ret += arg;
            ret += "\n";
        }
        
        ret += whiteSpace;
        
        ret += banner;
        
        if(print) {System.out.println(ret);}
        
        return ret;
    }
    
    public static final boolean quit(String s) {
        return (s.equalsIgnoreCase("quit") || s.equalsIgnoreCase("q"));
    }
}
