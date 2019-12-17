package com.sg.charactergen.objects;

import com.sg.charactergen.ui.UserIO;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    
    private static final int MAX_REROLLS = 3;
    
    private int currentRerolls;
    
    private List<StatType> statsRemaining;
    
    UserIO io;

    public Generator(UserIO io) {
        this.io = io;
        statsRemaining = new ArrayList<>(){{
            add(StatType.STRENGTH);
            add(StatType.DEXTERITY);
            add(StatType.CONSTITUTION);
            add(StatType.INTELLIGENCE);
            add(StatType.WISDOM);
            add(StatType.CHARISMA);
        }};
    }
    
    private static final Random random = new Random();
    
    public DnDCharacter generate(){
        currentRerolls = MAX_REROLLS;
        
        DnDCharacter dndCharacter = new DnDCharacter();
        
        int statsSet = 6;
        
        while(statsSet > 0){
            dndCharacter = setStats(dndCharacter);
        }
        
        return dndCharacter;
    }
    
    public int rollDice(int sides){
        return random.nextInt(sides + 1);
    }
    
    public void bubbleSort(int... args){
        int n = args.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(args[j] > args[j+1]){
                    int temp = args[j];
                    args[j] = args[j+1];
                    args[j+1] = temp;
                }
            }
        }
//        return args;
    }
    
    public int add(int... args){
        int ret = 0;
        for (int i = 0; i < args.length; i++) {
            ret += args[i];
        }
        return ret;
    }

    private int makeStat() {
        boolean statAccepted = false;
        
        int total = 0;
        
        while(!statAccepted){
            int[] stats = new int[]{
                rollDice(6),
                rollDice(6),
                rollDice(6),
                rollDice(6),
            };

            bubbleSort(stats);

            int[] reducedStats = new int[3];
            for (int i = 0; i < 3; i++) {
                reducedStats[i] = stats[i + 1];
            }

            total = add(reducedStats);
            String response = io.readRequiredString("Total is: " + total + ". Do you accept? (y/n)");
            if(response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")){
                if(currentRerolls > 0){
                    currentRerolls--;
                } else {
                    System.out.println("Out of rerolls.");
                    statAccepted = true;
                }

            } else {
                statAccepted = true;
            }
        }
        return total;
    }

    private void printStatsRemaining() {
        for (StatType statType : statsRemaining) {
            System.out.println(statType.getName());
        }
    }

    private DnDCharacter setStats(DnDCharacter dndCharacter) {
         
        boolean statSetAcceptable = false;
        while(!statSetAcceptable){
            int newStat = makeStat();
            printStatsRemaining();
            String placement = io.readRequiredString("What stat will you assign " + newStat + " to?").toLowerCase();
            if(!statsRemaining.isEmpty()){
                for (StatType statType : statsRemaining) {
                    if(placement.equalsIgnoreCase(statType.getName())){
                        switch(placement){
                            case "str":
                                dndCharacter.setSTR(newStat);
                                break;
                            case "dex":
                                dndCharacter.setDEX(newStat);
                                break;
                            case "con":
                                dndCharacter.setCON(newStat);
                                break;
                            case "int":
                                dndCharacter.setINT(newStat);
                                break;
                            case "wis":
                                dndCharacter.setWIS(newStat);
                                break;
                            case "chr":
                                dndCharacter.setCHR(newStat);
                                break;

                        }
                    }
                }
            } else {
                return dndCharacter;
            }
        }
        return dndCharacter;
    }
}
