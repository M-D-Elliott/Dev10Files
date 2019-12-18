package com.sg.dentalclinic.models;

public class Person extends DBObject {
    private String firstName;
    private String lastName;

    public Person() {
    }
    
    public Person(int ID, String firstName, String lastName) {
        super(ID);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
