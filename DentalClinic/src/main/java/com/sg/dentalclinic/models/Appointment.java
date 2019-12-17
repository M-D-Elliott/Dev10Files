package com.sg.dentalclinic.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Appointment extends DBObject  {
    private LocalDate startTime;
    private LocalDate endTime;

    private BigDecimal costToCustomer;
    private String notes;
    
    // To store reference values to other DB objects
    private int customerID;
    private int professionalID;
    private List<Integer> modifiedByIDs;
    
    // to store temporary references to other DB objects.
    private Customer customer;
    private Professional professional;
    private List<User> modifiedBy;

    public Appointment(int ID, int customerID, int professionalID, LocalDate startTime, LocalDate endTime) {
        super(ID);
        this.customerID = customerID;
        this.professionalID = professionalID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    
    // getters and setters
    public int getCustomerID() {
        return customerID;
    }

    public int getProfessionalID() {
        return professionalID;
    }

    public void setProfessionalID(int professionalID) {
        this.professionalID = professionalID;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
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
}
