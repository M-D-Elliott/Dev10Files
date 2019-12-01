package exercises2;

import java.util.Scanner;

public class AllAboutMe {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Your name?");
        String name = scanner.nextLine();
        
        System.out.println("Favorite food?");
        String food = scanner.nextLine();
        
        scanner.nextLine();
        System.out.println("How many pets?");
        int pets = scanner.nextInt();
        
        System.out.println("Have you eaten gnocchi?");
        String response = scanner.nextLine();
        boolean eatenGnocchi = (response == "yes" || response == "y") ? true : false;
        
        scanner.nextLine();
        System.out.println("What age did you learn to whistle?");
        int whistleAge = scanner.nextInt();
        
        System.out.println("I am " + name);
        System.out.println("My favorite food is " + food);
        System.out.println("I have " + pets + " pets.");
        String eatenGnocchiString = (!eatenGnocchi) ? "not " : "";
        System.out.println("I have " + eatenGnocchiString + "eaten gnocchi.");
        System.out.println("And when I was " + whistleAge + " I learned to whistle");
        
    }
}
