/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dentalclinic.ui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public interface UserIO {

    void CLS() throws IOException, InterruptedException;

    // I did not write this cls function, but found it via stack overflow!
    void cls();

    void print(String message);

    boolean quit(String s);

    boolean readBoolean(String prompt);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    int readInt(String prompt);

    int tryParseInt(String string);
    
    int readInt(String prompt, int min, int max);

    String readRequiredString(String prompt);

    String readString(String prompt);

    public LocalDate readRequiredDate(String prompt, DateTimeFormatter BASIC_ISO_DATE);
    
}
