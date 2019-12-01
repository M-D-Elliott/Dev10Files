package exercises3;

import java.util.Scanner;

public class DoItBetter {
    private Scanner sc = new Scanner(System.in);
    public void run() {
        int miles = readInput("How many miles can you run?");
        System.out.println("Ha, I can run " + better(miles));
        
        int hotdogs = readInput("How many hotdogs can you eat?");
        System.out.println("Ha, I can eat " + better(hotdogs));
        
        int languages = readInput("How many languages do you know?");
        System.out.println("Ha!!! I know " + better(languages) + " languages!");
    }
    
    public int readInput(String prompt) {
        System.out.println(prompt + " ");
        return sc.nextInt();
    }
    
    public int better(int n) {
        return n * 2 + 1;
    }
}
