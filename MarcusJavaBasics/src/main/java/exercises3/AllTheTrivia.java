package exercises3;

import java.util.Scanner;

public class AllTheTrivia {
    private Scanner sc = new Scanner(System.in);
    public void run() {
        String answer1 = readInput("1024 Gigabytes is equal to one what?");
        String answer2 = readInput("In our solar system, which is the only planet that rotates clockwise?");
        String answer3 = readInput("The largest volcano ever discovered in our Solar System is located on which planet?");
        String answer4 = readInput("What is the most abundant element in the earth's atmosphere?");
        
        System.out.println("Wow, 1024 gigabytes is " + answer2);
        System.out.println("I didn't know that the largest volcano was discovered on " + answer1);
        System.out.println("That's amazing that " + answer3 + " is the most abundant element in the atmosphere!");
        System.out.println(answer4 + " is the only planet that rotates clockwise, neat!");
    }
    
    public String readInput(String prompt) {
        System.out.println(prompt + " ");
        return sc.nextLine();
    }
}
