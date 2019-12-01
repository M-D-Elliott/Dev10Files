package exercises5;

import java.util.Random;

public class CoinFlipper {
    private Random random = new Random();
    public boolean run() {
        System.out.println("Ready, set, flip!!!!");
        boolean sideBool = random.nextBoolean();
        if(sideBool){
            System.out.println("Heads!");
        } else {
            System.out.println("Tails!!!");
        }
        return sideBool;
    }
}
