package com.sg.bugsafari.data;

// this type of exception is checked, runtime exception is not.
public class DataException extends Exception {
    public DataException(String message){
        super(message);
    }
    
    public DataException(String message, Exception rootCause){
        super(message, rootCause);
    }
}
