package com.sg.dentalclinic.data;

public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable innerEx) {
        super(message, innerEx);
    }
}
