package com.sg.dentalclinic.models;

import java.math.BigDecimal;

public class Professional extends Person {
    public Specialty specialty;
    public BigDecimal hourlyRate;

    public Professional(int ID, String firstName, String lastName) {
        super(ID, firstName, lastName);
    }
    
    public Professional(int ID, String firstName, String lastName, Specialty specialty, BigDecimal hourlyRate) {
        super(ID, firstName, lastName);
        this.specialty = specialty;
        this.hourlyRate = hourlyRate;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
