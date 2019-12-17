package com.sg.dentalclinic.service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public final class Validations {
    
    private static final int BASE_ZIP_LENGTH = 5;
    private static final int FULL_ZIP_LENGTH = 9;

    public static boolean inRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public static boolean isNullOrWhitespace(String value) {
        return value == null || value.trim().length() == 0;
    }
    
    public static boolean isUnique(int[] allInts, int id) {
        for (int i = 0; i < allInts.length; i++) {
            if(allInts[id] == allInts[i] && id != i){
                return false;
            }
        }
        return true;
    }

    public static boolean isEmail(String emailAddress) {

        if (isNullOrWhitespace(emailAddress)) {
            return false;
        }

        try {
            InternetAddress addr = new InternetAddress(emailAddress);
            addr.validate();
            return true;
        } catch (AddressException ex) {
            return false;
        }
    }

    public static boolean isZipCode(String zip) {
        int length = zip.length();
        
        if(length == BASE_ZIP_LENGTH || length == FULL_ZIP_LENGTH){
            return true;
        } else {
            return false;
        }
    }
}
