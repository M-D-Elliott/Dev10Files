package com.sg.internationalspacestation.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class SpaceStation2 {
    private HashMap<LocalDate, ArrayList<Visitor>> allVisitors;
    private int maxVehicles;
    private int maxAstronauts;
    
    public SpaceStation2() {
        this.allVisitors = new HashMap<>();
        
        this.maxVehicles = 2;
        this.maxAstronauts = 6;
    }
    
    public boolean add (Visitor v) {
        if(v == null){
            return false;
        }
        LocalDate today = v.getStart();
        ArrayList<Visitor> todaysVisitors = allVisitors.get(today);
        
        if(todaysVisitors == null){
            todaysVisitors = createTodaysVisitors(allVisitors, todaysVisitors, today);
        }
        
        VisitorType type = v.getType();
        switch(type){
            case ASTRONAUT:
                if(visitorCount(todaysVisitors, type) <= maxAstronauts){
                    todaysVisitors.add(v);
                    allVisitors.replace(today, todaysVisitors);
                    return true;
                }
                break;
            case VEHICLE:
                if(visitorCount(todaysVisitors, type) <= maxVehicles){
                    todaysVisitors.add(v);
                    allVisitors.replace(today, todaysVisitors);
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

    private int visitorCount(ArrayList<Visitor> todaysVisitors, VisitorType type) {
        int count = 0;
        for (Visitor v : todaysVisitors) {
            count = (v.getType() == type) ? count + 1 : count;
        }
        return count;
    }
    
    private ArrayList<Visitor> createTodaysVisitors(HashMap<LocalDate, ArrayList<Visitor>> visitors, ArrayList<Visitor> todaysVisitors, LocalDate today) {
        visitors.put(today, new ArrayList<>());
        if(visitors.keySet().size() > 1){
            todaysVisitors = visitors.get(today);
            todaysVisitors = fillTodayWithPreviousDays(visitors, todaysVisitors, today);
        } else {
            todaysVisitors = new ArrayList<>();
        }
        return todaysVisitors;
    }

    private ArrayList<Visitor> fillTodayWithPreviousDays(HashMap<LocalDate, ArrayList<Visitor>> visitors, ArrayList<Visitor> todaysVisitors, LocalDate today) {
        LocalDate prevDay = today.minusDays(1);
        while(visitors.get(prevDay) == null){
            prevDay = prevDay.minusDays(1);
        }
        for (Visitor prevVisitor : visitors.get(prevDay)) {
            if(prevVisitor.getEnd() == null || prevVisitor.getEnd().isAfter(today)){
                todaysVisitors.add(prevVisitor);
            }
        }
        return todaysVisitors;
    }

    public HashMap<LocalDate, ArrayList<Visitor>> getAllVisitors() {
        return allVisitors;
    }

    public int getMaxVehicles() {
        return maxVehicles;
    }

    public int getMaxAstronauts() {
        return maxAstronauts;
    }
}
