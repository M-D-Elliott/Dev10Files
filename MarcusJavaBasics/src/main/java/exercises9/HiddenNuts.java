package exercises9;

import java.util.Random;

public class HiddenNuts {
    public void run() {
        
        String[] nuts = new String[100];
        Random squirrel = new Random();
        nuts[squirrel.nextInt(nuts.length)] = "Nut";
        System.out.println("The nut has been hidden ...");
        for(int i = 0; i < nuts.length - 1; i++) {
            if(nuts[i] != null) {
                System.out.println(nuts[i] + " " + i);
            }
        }
    }
}
