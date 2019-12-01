package com.mycompany.statecapitalsv2.App;

import java.util.HashMap;
import java.util.Map;
import com.mycompany.statecapitalsv2.Objects.State;
import com.mycompany.statecapitalsv2.Objects.Capital;
import com.mycompany.statecapitalsv2.Objects.IJurisdiction;
import com.mycompany.statecapitalsv2.UserIO.UserIO;
import com.mycompany.statecapitalsv2.UserIO.UserIOImplementation;

public class Application {

    private Map<IJurisdiction, IJurisdiction> stateCapitalMap;
    
    private int bannerRepeat;
    private String banner;
    
    private UserIO io;
    
    public Application() {
        bannerRepeat = 8;
        banner = "=".repeat(bannerRepeat);
        io = new UserIOImplementation();
    }
    
    public void setUp(){
        stateCapitalMap = new HashMap<>(){{
            put(new State("Alabama"), new Capital("Montgomery", 205000, 156));
            put(new State("Alaska"), new Capital("Juneau", 31000, 3255));
            put(new State("Arizona"), new Capital("Phoenix", 1445000, 517));
            put(new State("Arkansas"), new Capital("Little Rock", 193000, 116));
            put(new State("Illinois"), new Capital("Springfield"));
        }};
    }
    
    public void start(){
        setUp();
        
        printStateCapitalPairsInfo(stateCapitalMap);
        
        askAndPrintLowerLimit(stateCapitalMap);
        
//        printStates(stateCapitalMap);
//        printCapitals(stateCapitalMap);
//        printKeyValuePairs(stateCapitalMap);
    }

    private void printKeyValuePairs(Map<State, Capital> stateCapitalMap) {
        System.out.println("STATE/CAPITAL Pairs: ");
        System.out.println(banner);
        stateCapitalMap.keySet().forEach((state) -> {
            String capital = stateCapitalMap.get(state).toString();
            System.out.println(state + " --- " + capital);
        });
        System.out.println("");
    }

    private void printStates(Map<State, Capital> stateCapitalMap){
        System.out.println("States: ");
        System.out.println(banner);
        stateCapitalMap.keySet().forEach((state) -> {
            System.out.println(state);
        });
        System.out.println("");
    }
    
    private void printCapitals(Map<State, Capital> stateCapitalMap){
        System.out.println("Capitals:");
        System.out.println(banner);
        stateCapitalMap.keySet().forEach((state) -> {
            String capital = stateCapitalMap.get(state).toString();
            System.out.println(capital);
        });
        System.out.println("");
    }

    private void printStateCapitalPairsInfo(Map<IJurisdiction, IJurisdiction> stateCapitalMap){
        printStateCapitalPairsInfo(stateCapitalMap, "STATE/CAPITAL Pairs: ");
    }
    
    private void printStateCapitalPairsInfo(Map<IJurisdiction, IJurisdiction> stateCapitalMap, String prompt) {
        System.out.println("");
        System.out.println(prompt);
        System.out.println(banner);
        stateCapitalMap.keySet().forEach((state) -> {
            IJurisdiction capital = stateCapitalMap.get(state);
            
            
            String out = state + " --- " + capital;
            out += " | Pop: " + capital.getPopulation();
            out += " | Area: " + capital.getSquareMileage() + " sq. mi.";
            System.out.println(out);
        });
        System.out.println("");
    }

    private void askAndPrintLowerLimit(Map<IJurisdiction, IJurisdiction> stateCapitalMap) {
        int lowerLimit = io.readInt("Please enter the lower limit for capital city population:");
        
        Map<IJurisdiction, IJurisdiction> filteredStateCapitalMap = new HashMap<>();
        
        for (IJurisdiction state : stateCapitalMap.keySet()) {
            
            IJurisdiction capital = stateCapitalMap.get(state);
            
            int population = capital.getPopulation();
            
            if(population > lowerLimit){
                filteredStateCapitalMap.put(state, capital);
            }
        }
        if(filteredStateCapitalMap.keySet().isEmpty()){
            System.out.println("No results");
        } else {
            printStateCapitalPairsInfo(filteredStateCapitalMap);
        }
    }
    
    
}
