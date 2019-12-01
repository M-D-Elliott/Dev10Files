package com.mycompany.statecapitalsv2.Objects;

public class State extends Jurisdiction {

    public State() {
    }

    public State(String name) {
        super(name);
    }
    
    public State(String name, int population, int squareMileage) {
        super(name, population, squareMileage);
    }
}
