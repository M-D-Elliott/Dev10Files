
package exercises4;

import java.util.Random;
import java.util.Scanner;

public class PickANumber {
    public void run(int max) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int answer = random.nextInt(max) + 1;
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
        }
    }
}
