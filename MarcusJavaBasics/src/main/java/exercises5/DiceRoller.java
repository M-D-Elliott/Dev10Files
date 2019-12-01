package exercises5;

import java.util.Random;

public class DiceRoller {
    public void run(int sides) {
        Random diceRoller = new Random();

        int rollResult = diceRoller.nextInt(sides) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        } else if (rollResult == sides) {
            System.out.println("Critical!");
        }
    }
}
