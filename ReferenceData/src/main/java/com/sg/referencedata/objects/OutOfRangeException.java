package com.sg.referencedata.objects;

public class OutOfRangeException extends Exception {
    public OutOfRangeException(String message) {
        super(message);
    }

    public OutOfRangeException(String message, Throwable innerEx) {
        super(message, innerEx);
    }
}
