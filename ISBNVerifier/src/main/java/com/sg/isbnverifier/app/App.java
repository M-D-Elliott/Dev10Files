package com.sg.isbnverifier.app;

import com.sg.isbnverifier.utils.CharUtils;

public class App {
    public void run() {
        String[] testCases = new String[]{
            "978-3-16-148410-0",
            "978-3-16-14841j-0",
            "9",
            "9993334441",
            "400",
            "978-3-16",
            "455445469",
            "999333444j1",
            "40055667",
            "978-3-16",
            "455445469",
            "999333444j1",
            "40055667",
        };
        
        for (String testCase : testCases) {
            boolean isValid = verifyISBN(testCase);
            if(isValid){
                System.out.println("valid");
            }  else {
                System.out.println("invalid");
            }
        }
    }

    private boolean verifyISBN(String isbn) {
        isbn = isbn.replace("-", "");

        for (char c : isbn.toCharArray()) {
           if(!(c >= '0' && c <= '9')){
               return false;
           }
        }
        int length = isbn.length();
        if(length == 10 || length == 13){
            return true;
        }
        return false;
    }
}
