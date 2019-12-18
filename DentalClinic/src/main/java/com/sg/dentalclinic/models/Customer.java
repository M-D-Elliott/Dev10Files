package com.sg.dentalclinic.models;

import java.time.LocalDate;

public class Customer extends Person {

    private LocalDate dateOfBirth;

    public Customer() {
    }
    
    public Customer(int ID, String firstName, String lastName, LocalDate dateOfBirth) {
        super(ID, firstName, lastName);
        this.dateOfBirth = dateOfBirth;
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
