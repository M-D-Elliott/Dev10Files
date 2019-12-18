package com.sg.dentalclinic.models;

public class DBObject {
    protected int ID;

    public DBObject() {
    }
    
    public DBObject(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}
