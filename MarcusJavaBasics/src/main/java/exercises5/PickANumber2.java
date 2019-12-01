package exercises5;

import java.util.Random;
import java.util.Scanner;

public class PickANumber2 {
    public void run() {
        run(-100, 100);
    }
    
     public void run(int min, int max) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int answer = random.nextInt(max - min) + min;
        int guess = 0;
        int tries = 3;
        while(guess != answer && tries > 0) {
            System.out.println("Pick a number!");
            guess = scanner.nextInt();
            if(guess == answer) {
                System.out.println("You win!");
                break;
            }
            System.out.println("Wrong!");
            tries--;
        }
        if(tries == 0) {
            System.out.println("You lose!");
            System.out.println("The number was " + answer);
        }
    }
}
