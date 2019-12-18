package com.sg.dentalclinic.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Appointment extends DBObject  {
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;

    private BigDecimal costToCustomer;
    private String notes;
    
    // To store reference values to other DB objects
    private int customerID;
    private String professionalLastName;
    private Specialty professionalSpecialty;
    
    private List<Integer> modifiedByIDs;
    
    // to store temporary references to other DB objects.
    private Customer customer;
    private Professional professional;
    private List<User> modifiedBy;

    public Appointment(int customerID, 
            String professionalLastName, 
            Specialty professionalSpecialty, 
            LocalTime startTime, 
            LocalTime endTime, 
            BigDecimal costToCustomer, 
            String notes,
            LocalDate date){
        
            this.customerID = customerID;
            this.professionalLastName = professionalLastName;
            this.professionalSpecialty = professionalSpecialty;
            this.startTime = startTime;
            this.endTime = endTime;
            this.costToCustomer = costToCustomer;
            this.notes = notes;
            this.date = date;
    }

    @Override
    public String toString() {
        return customer + " will see " + professional + " on " + date + " from " + startTime + " to " + endTime + ", notes: " + notes;
    }
    
    

    // getters and setters
    public int getCustomerID() {
        return customerID;
    }

//    public int getProfessionalID() {
//        return professionalID;
//    }
//
//    public void setProfessionalID(int professionalID) {
//        this.professionalID = professionalID;
//    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    
    public BigDecimal getCostToCustomer() {
        return costToCustomer;
    }

    public void setCostToCustomer(BigDecimal costToCustomer) {
        this.costToCustomer = costToCustomer;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void addToModifiedBy(int ID){
        modifiedByIDs.add(ID);
    }
    
    public List<Integer> getModifiedByIDs() {
        return modifiedByIDs;
    }

    public void setModifiedByIDs(List<Integer> modifiedByIDs) {
        this.modifiedByIDs = modifiedByIDs;
    }

    
    // for temporary DB objects.
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public List<User> getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(List<User> modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getProfessionalLastName() {
        return professionalLastName;
    }

    public void setProfessionalLastName(String professionalLastName) {
        this.professionalLastName = professionalLastName;
    }

    public Specialty getProfessionalSpecialty() {
        return professionalSpecialty;
    }

    public void setProfessionalSpecialty(Specialty professionalSpecialty) {
        this.professionalSpecialty = professionalSpecialty;
    }
}
