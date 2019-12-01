package com.mycompany.statecapitalsv2.Objects;

public class Jurisdiction implements IJurisdiction {
    protected String name;
    protected int population;
    protected int squareMileage;

    public Jurisdiction() {
    }

    public Jurisdiction(String name) {
        this(name, 0);
    }

    public Jurisdiction(String name, int population) {
        this(name, population, 0);
    }
    
    public Jurisdiction(String name, int population, int squareMileage) {
        this.name = name;
        this.population = population;
        this.squareMileage = squareMileage;
    }

    @Override
    public String toString(){
        return this.name;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPopulation() {
        return population;
    }

    @Override
    public int getSquareMileage() {
        return squareMileage;
    }
}
