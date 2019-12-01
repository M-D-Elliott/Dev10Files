package exercises3;

import java.util.Scanner;

public class PassingTheTuringTest {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        
        System.out.println("Hi, " + name + "! What's your favorite color?");
        String color = scanner.nextLine();
        
        System.out.println("Huh, " + color + " Mine's electric lime.");
        System.out.println("I really like limes. They're my favorite fruit, too.");
        System.out.println("What's your favorite fruit, " + name + "?");
        String fruit = scanner.nextLine();
        
        System.out.println("Really? " + fruit + "? That's wild!");
        
        System.out.println("Speaking of favorites, what's your favorite number? ");
        int number = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println(number + " is a cool number. Mine's -7!");
        System.out.println("Did you know that " + number + " * -7 is " + number * -7 + "? That's a cool number too!");
        
        System.out.println("Well, thanks for talking to me, " + name + "!");
    }
    
}
