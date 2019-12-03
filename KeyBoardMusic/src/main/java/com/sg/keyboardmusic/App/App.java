package com.sg.keyboardmusic.App;

import com.sg.keyboardmusic.UserIO.UserIO;
import java.util.ArrayList;

public class App {
    
    private boolean keepGoing;

    private ArrayList<String> stepList = new ArrayList<>(){{
        add("A");
        add("A#");
        add("B");
        add("C");
        add("C#");
        add("D");
        add("D#");
        add("E");
        add("F");
        add("F#");
        add("G");
        add("G#");
    }};
    
    UserIO io;

    public App(UserIO io) {
        this.io = io;
        reset();
    }
    
    public void run() {
        reset();
        menuLoop();
    }

    private void menuLoop() {
        while(keepGoing){
            io.print("Finding major thirds:");
            String userInput = io.readString("Please enter a musical semitone or halfstep.");
            
            io.print(transcribe(userInput, 4));
            
            io.print();
        }
    }

    private void reset() {
        keepGoing = true;
    }

    private String transcribe(String note, int steps) {
        String letter = note.substring(0, 1);
        String halfNote = "";
        int direction = 1;
        
        String ret = "Error: invalid input.";
        if(note.length() == 1){
            if(Character.isLowerCase(letter.toCharArray()[0])){
                direction = -1;
            }
        }else if (note.length() > 1) {
            halfNote = note.substring(1, 2);
        } else if (note.length() > 2) {
            return ret;
        }
        
        letter += halfNote;
        int index = 0;
        for (String stepNote : stepList) {
            if (stepNote.equalsIgnoreCase(letter)){
                int newPosition = index + direction * steps;
                if(newPosition > stepList.size()){
                    newPosition -= stepList.size();
                } else if(newPosition < 0) {
                    newPosition = stepList.size() - newPosition;
                }
                ret = stepList.get(newPosition);
            }
            index++;
        }
        
        return ret;
    }

}
