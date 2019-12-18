package com.sg.dentalclinic.ui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleIO implements UserIO {

    private static final String INVALID_NUMBER
            = "[INVALID] Enter a valid number.";
    private static final String NUMBER_OUT_OF_RANGE
            = "[INVALID] Enter a number between %s and %s.";
    private static final String REQUIRED
            = "[INVALID] Value is required.";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        print("");
        String ret = scanner.nextLine();
        print("");
        return ret;
    }

    @Override
    public String readRequiredString(String prompt) {
        while (true) {
            String result = readString(prompt);
            if (!result.isBlank()) {
                return result;
            }
            print(REQUIRED);
        }
    }

    @Override
    public double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readRequiredString(prompt));
            } catch (NumberFormatException ex) {
                print(INVALID_NUMBER);
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        while (true) {
            double result = readDouble(prompt);
            if (result >= min && result <= max) {
                return result;
            }
            print(String.format(NUMBER_OUT_OF_RANGE, min, max));
        }
    }

    @Override
    public int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readRequiredString(prompt));
            } catch (NumberFormatException ex) {
                print(INVALID_NUMBER);
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        while (true) {
            int result = readInt(prompt);
            if (result >= min && result <= max) {
                return result;
            }
            print(String.format(NUMBER_OUT_OF_RANGE, min, max));
        }
    }
    
    @Override
    public int tryParseInt(String string){
        try{
            return Integer.parseInt(string);
        } catch(NumberFormatException e){
            
        }
        return 0;
    }

    @Override
    public boolean readBoolean(String prompt) {
        while (true) {
            String input = readRequiredString(prompt).toLowerCase();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            }
            print("[INVALID] Please enter 'y' or 'n'.");
        }
    }
    
    @Override
    public boolean quit(String s) {
        return (s.equalsIgnoreCase("quit") || s.equalsIgnoreCase("q"));
    }
    
    // I did not write this cls function, but found it via stack overflow!
    @Override
    public void cls() {
        System.out.print("\033[H\033[2J");  
        System.out.print("\033[H\033[2J"); 
        System.out.flush();  
    }
    
    @Override
    public void CLS() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    @Override
    public LocalDate readRequiredDate(String prompt, DateTimeFormatter formatter) {
        String input = readRequiredString(prompt);
        input = input.replace("-", "");
        input = input.replace("/", "");
        
        LocalDate returnDate = null;
        
        try{
            returnDate = LocalDate.parse(input, formatter);
        } catch(DateTimeParseException ex){
            print("Bad date entry");
        }
        return returnDate;
    }
}
