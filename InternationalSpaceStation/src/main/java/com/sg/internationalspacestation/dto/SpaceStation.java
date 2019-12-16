package com.sg.internationalspacestation.dto;

import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
    
    private List<Visitor> visitors;
    private int vehicleCount;
    private int astronautCount;
    
    public static final int MAX_VEHICLES = 2;
    public static final int MAX_ASTRONAUTS = 6;

    public SpaceStation() {
        this(new ArrayList<>());
    }

    public SpaceStation(List<Visitor> visitors) {
        this.visitors = visitors;
        int vehicleCount = 0;
        int astronautCount = 0;
    }
    
    public boolean add (Visitor v) {
        if(v == null){
            return false;
        }
        switch(v.getType()){
            case ASTRONAUT:
                astronautCount++;
                if(astronautCount > MAX_ASTRONAUTS){
                    System.out.println("Too many astronauts.");
                    astronautCount = MAX_ASTRONAUTS;
                    return false;
                }
                break;
            case VEHICLE:
                vehicleCount++;
                if(vehicleCount > MAX_VEHICLES){
                    vehicleCount = MAX_VEHICLES;
                    System.out.println("Too many vehicles.");
                    return false;
                }
                break;
            default:
                break;
        }
        return visitors.add(v);
    }
}
