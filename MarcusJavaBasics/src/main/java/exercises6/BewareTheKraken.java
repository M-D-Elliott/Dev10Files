package exercises6;

import java.util.Random;
import java.util.Scanner;

public class BewareTheKraken {
    private Scanner _sc = new Scanner(System.in);
    private Random _random = new Random();
    private String[] _fish = new String[5];

    public void run() {
        fillFish();
        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

        int depthDivedInFt = 0;

        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        while(depthDivedInFt < 36200){
            // if the while loops condition is true it will not make a difference here,
            // because the depth dived 20k feet will stop this loop anyway. Still,
            // it is good to have an out condition for a while loop in general.
            System.out.println("So far, we've swum " + depthDivedInFt + " feet");
            String randomFish = _fish[randomInt(0, _fish.length - 1)];
            System.out.println("You see a " + randomFish);
            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }
            String command = readInput("Would you like to stop? y/n");
            if("y".equals(command)) {
                break;
            }
            // I can swim, really fast! 500ft at a time!
            depthDivedInFt += 1000;
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
    
    public String readInput(String prompt) {
        System.out.println(prompt + " ");
        return _sc.nextLine();
    }
    
    public void fillFish() {
        _fish[0] = "Baracouda";
        _fish[1] = "Trout";
        _fish[2] = "Tuna";
        _fish[3] = "Bass";
        _fish[4] = "Rainbow Fish";
    }
    
    public int randomInt(int min, int max) {
        return _random.nextInt(max - min + 1) + min;
    }
}
