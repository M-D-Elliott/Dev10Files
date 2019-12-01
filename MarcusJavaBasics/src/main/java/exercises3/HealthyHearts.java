
package exercises3;

import java.util.Scanner;

public class HealthyHearts {
    private Scanner sc = new Scanner(System.in);
    public void run() {
        int age = readInput("What is your age?");
        int max = 220 - age;
        System.out.println("Your max heart rate should be " + max + " beats per minute.");
        System.out.println("Your target HR zone is " + max * .5 + " - " + max * .85 + " beats per minute.");
    }
    
    public int readInput(String prompt) {
        System.out.println(prompt + " ");
        return sc.nextInt();
    }
}
