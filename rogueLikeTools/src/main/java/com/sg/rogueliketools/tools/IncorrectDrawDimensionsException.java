package com.sg.rogueliketools.tools;

public class IncorrectDrawDimensionsException extends Exception {
    public IncorrectDrawDimensionsException(String message) {
        super(message);
    }
    
    public IncorrectDrawDimensionsException(String message, Throwable cause) {
        super(message, cause);
    }
}
