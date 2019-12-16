package com.sg.dentalclinic.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Appointment extends DBObject  {

    private int customerID;
    private int professionalID;
    private List<Integer> modifiedByIDs;
    
    private LocalDate startTime;
    private LocalDate endTime;

    private BigDecimal costToCustomer;
    
    private String notes;

    public Appointment(int ID, int customerID, int professionalID, LocalDate startTime, LocalDate endTime) {
        super(ID);
        this.customerID = customerID;
        this.professionalID = professionalID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

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
}
