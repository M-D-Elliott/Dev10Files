package exercises3;

import java.util.Scanner;

public class MiniMadLibs {
    private Scanner sc = new Scanner(System.in);
    public void run() {
        String noun1 = readInput("I need a noun:");
        String adjective1 = readInput("Now an adjective:");
        String noun2 = readInput("Another noun:");
        String number1 = readInput("And a number:");
        String adjective2 = readInput("Another adjective:");
        String noun3 = readInput("A plural noun: ");
        String noun4 = readInput("Another one:");
        String noun5 = readInput("One more:");
        String verb1 = readInput("A verb:");
        String verb2 = readInput("Same verb, but past tense:");
        
        System.out.println(noun1 + ": the " + adjective1 + " frontier. These are the voyages of the starship " 
                           + noun2 + ". Its " + number1 + "-year mission: to explore strange " + adjective2 
                           + " " + noun3 + ", to seak out " + adjective2 + " " + noun4 + " and " + adjective2 + " "
                           + noun5 + ", to boldly " + verb1 + " where no one has " + verb2 + " before.");
    }
    
    public String readInput(String prompt) {
        System.out.println(prompt + " ");
        return sc.nextLine();
    }
}
