package com.mycompany.statecapitalsv1.Objects;

public class Jurisdiction implements IJurisdiction {
    protected String name;

    public Jurisdiction(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
