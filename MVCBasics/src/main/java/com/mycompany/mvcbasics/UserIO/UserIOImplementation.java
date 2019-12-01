package com.mycompany.mvcbasics.UserIO;

import java.util.Scanner;

public class UserIOImplementation implements UserIO{

    private final Scanner SCANNER = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt + " ");
        double returnValue = SCANNER.nextDouble();
        SCANNER.nextLine();
        return returnValue;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double returnValue = 0.00;
        while(returnValue < min || returnValue > max){
            returnValue = readDouble(prompt);
        }
        return returnValue;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt + " ");
        float returnValue = SCANNER.nextFloat();
        SCANNER.nextLine();
        return returnValue;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float returnValue = 0;
        while(returnValue < min || returnValue > max){
            returnValue = readFloat(prompt);
        }
        return returnValue;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt + " ");
        int returnValue = SCANNER.nextInt();
        SCANNER.nextLine();
        return returnValue;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int returnValue = 0;
        while(returnValue < min || returnValue > max){
            returnValue = readInt(prompt);
        }
        return returnValue;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt + " ");
        long returnValue = SCANNER.nextLong();
        SCANNER.nextLine();
        return returnValue;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long returnValue = 0;
        while(returnValue < min || returnValue > max){
            readLong(prompt);
        }
        return returnValue;
    }

    @Override
    public String readString(String prompt) {
        return readString(prompt, true);
    }

    
    @Override
    public String readString(String prompt, boolean newLine) {
        System.out.print(prompt + " ");
        if(newLine){
            System.out.println("");
        }
        return SCANNER.nextLine();
    }
}
