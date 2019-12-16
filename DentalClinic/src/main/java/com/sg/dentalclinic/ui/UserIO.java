/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dentalclinic.ui;


public interface UserIO {

    void print(String message);

    boolean readBoolean(String prompt);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    String readRequiredString(String prompt);

    String readString(String prompt);
    
}
