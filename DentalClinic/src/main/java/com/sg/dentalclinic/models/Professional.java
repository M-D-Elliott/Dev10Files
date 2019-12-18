package com.sg.dentalclinic.models;

import java.math.BigDecimal;

public class Professional extends Person {
    private Specialty specialty;
    private BigDecimal hourlyRate;

    public Professional() {
        super();
    }
    
    public Professional(int ID, String firstName, String lastName, Specialty specialty, BigDecimal hourlyRate) {
        super(ID, firstName, lastName);
        this.specialty = specialty;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return super.toString() + " -- " + getSpecialty().getName();
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
