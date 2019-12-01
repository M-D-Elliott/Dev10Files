package Challenges;

import Utils.InOutUtils;

public class SimpleProgram {
    public void run() {
        String in = InOutUtils.readInput("Please enter a string!");
        String[] inArray = in.split("");
        String reversed = "";
        for(int i =inArray.length - 1;i>=0;i--){
            reversed += inArray[i];
        }
        InOutUtils.encaseInBanner(true, true,new String[]{
            "Input String:",
            in,
            "ReversedString:",
            reversed,
        });
    }
}
