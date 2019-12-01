package exercises6;

import java.util.Random;
import java.util.Scanner;

public class GuessMeFinally {
    private Scanner _sc = new Scanner(System.in);
    private Random _random = new Random();
    
    public void run() {
        run(-100, 100);
    }
    public void run(int min, int max) {
        int answer = randomInt(min, max);
        System.out.println("I've chosen a random number between " + min + " and " + max + ". Betcha can't guess it!");
        int guess = min - 100;
        while(guess != answer) {
            guess = readIntInput("You're guess:");
            if(guess == answer) {
                System.out.println("You win!");
                break;
            } else if(guess < answer) {
                System.out.println("Too Low!");
            } else if(guess > answer) {
                System.out.println("Too High!");
            }
            System.out.println("");
        }
    }
    
    public int readIntInput(String prompt) {
        System.out.println(prompt + " ");
        return _sc.nextInt();
    }
    
    public int randomInt(int min, int max) {
        return _random.nextInt(max - min + 1) + min;
    }
}
