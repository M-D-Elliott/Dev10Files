package com.sg.classroster.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

    private final Scanner sc;

    public UserIOConsoleImpl() {
        sc = new Scanner(System.in);
    }
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt + " ");
        double returnValue = sc.nextDouble();
        sc.nextLine();
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
        float returnValue = sc.nextFloat();
        sc.nextLine();
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
        int returnValue = sc.nextInt();
        sc.nextLine();
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
        long returnValue = sc.nextLong();
        sc.nextLine();
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
        return sc.nextLine();
    }

    @Override
    public boolean quit(String keyWord) {
        return (keyWord.equalsIgnoreCase("quit") || keyWord.equalsIgnoreCase("q"));
    }

    @Override
    public void encaseInBanner(String... inner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void encaseInBanner(boolean print, String... inner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void encaseInBanner(boolean print, boolean whiteSpace, String... inner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}