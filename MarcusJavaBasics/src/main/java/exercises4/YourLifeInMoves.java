package exercises4;

import java.util.Scanner;

public class YourLifeInMoves {
    private Scanner sc = new Scanner(System.in);
    public void run() {
        String name = readInput("Hey, let's play a game! What's your name?");
        int year = readIntInput("Ok, " + name + ", what year were you born?");
        if(year < 2005) {
            System.out.println("Pixars 'Up' came out half a decade ago");
        }
        if(year < 1995) {
            System.out.println("The first harry potter move came out over 15 years ago.");
        }
        if(year < 1985) {
            System.out.println("Space jam came out not last decade, but the one before!");
        }
        if(year < 1975) {
            System.out.println("The og. jurassic park release is closer to the date of the first lunar landing than today.");
        }
        if(year < 1965) {
            System.out.println("Mash has been around for almost half a century!");
        }
    }
    
    public String readInput(String prompt) {
        System.out.println(prompt + " ");
        return sc.nextLine();
    }
    
    public int readIntInput(String prompt) {
        System.out.println(prompt + " ");
        return sc.nextInt();
    }
}
