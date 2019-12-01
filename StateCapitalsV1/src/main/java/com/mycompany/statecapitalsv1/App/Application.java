package com.mycompany.statecapitalsv1.App;

import com.mycompany.statecapitalsv1.Objects.Capital;
import com.mycompany.statecapitalsv1.Objects.State;
import java.util.HashMap;
import java.util.Map;

public class Application {

    private Map<State, Capital> stateCapitalMap;
    
    private int bannerRepeat;
    private String banner;
    
    public Application() {
        bannerRepeat = 8;
        banner = "=".repeat(bannerRepeat);
    }
    
    public void setUp(){
        stateCapitalMap = new HashMap<>(){{
            put(new State("Alabama"), new Capital("Montgomery"));
            put(new State("Alaska"), new Capital("Juneau"));
            put(new State("Arizona"), new Capital("Phoenix"));
            put(new State("Arkansas"), new Capital("Little Rock"));
            put(new State("Illinois"), new Capital("Springfield"));
        }};
    }
    
    public void start(){
        setUp();
        
        printStates(stateCapitalMap);
        printCapitals(stateCapitalMap);
        printKeyValuePairs(stateCapitalMap);
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
}
