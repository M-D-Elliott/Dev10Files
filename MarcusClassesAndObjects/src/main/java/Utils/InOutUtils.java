package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class InOutUtils {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String BANNER = "==".repeat(30);
    
    private InOutUtils() {
    }
    
    public static final String read(String prompt) {
        return read(prompt, true);
    }
    
    public static final String read(String prompt, boolean newLine){
        System.out.print(prompt + " ");
        if(newLine){
            System.out.println("");
        }
        return SCANNER.nextLine();
    }
    
    public static final char readChar(String prompt){
        return readChar(prompt, true);
    }
    
    public static final char readChar(String prompt, boolean newLine){
        System.out.print(prompt + " ");
        if(newLine){
            System.out.println("");
        }
        return SCANNER.nextLine().toCharArray()[0];
    }
    
     public static final int tryReadInt(String prompt) {
        return tryReadInt(prompt, "I need an integer!");
    }
     
     // I got this from a stack overflow answer.
    public static final int tryReadInt(String prompt, String message) {
        int number;
        do {
            System.out.println(prompt);
            while (!SCANNER.hasNextInt()) {
                System.out.println(message);
                SCANNER.next(); // this is important!
            }
            number = SCANNER.nextInt();
        } while (number <= 0);
        SCANNER.nextLine();
        return number;
    }
    
    public static final double readDouble(String prompt) {
        System.out.println(prompt + " ");
        double ret = SCANNER.nextDouble();
        SCANNER.nextLine();
        return ret;
    }
    
    public static final boolean readBoolean(String prompt) {
        System.out.println(prompt + " ");
        boolean ret = SCANNER.nextBoolean();
        SCANNER.nextLine();
        return ret;
    }
    
    public static final void printBanner(){
        System.out.println(BANNER);
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
        
        ret += whiteSpace;
        
        for(String arg : args) {
            ret += arg;
            ret += "\n";
            ret += whiteSpace;
        }
        
        ret += whiteSpace;
        
        ret += banner;
        
        if(print) {System.out.println(ret);}
        
        return ret;
    }
    
    public static final boolean quit(String s) {
        return (s.equalsIgnoreCase("quit") || s.equalsIgnoreCase("q"));
    }
    
    // I did not write this cls function, but found it via stack overflow!
    public static final void cls() {
        System.out.print("\033[H\033[2J");  
        System.out.print("\033[H\033[2J"); 
        System.out.flush();  
    }
    
    public static final void CLS() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    
    public static final void writeFile(String fileName, String[] data) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (String line : data) {
                out.println(line);
            }
            out.flush();
        } catch(IOException e) {
            System.out.println(e);
            System.out.println("Got an IOException, meekus");
        }
    }
    
    public static final String readFile() throws IOException {
        Scanner sc = new Scanner(
                new BufferedReader(
                        new FileReader("OutFile.txt")
                )
        );
        
        String ret = "";
        
        //iteration
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            ret += currentLine + "\n";
        }
        return ret;
    }
}
