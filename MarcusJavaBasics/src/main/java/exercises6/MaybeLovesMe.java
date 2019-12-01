package exercises6;

import java.util.Random;

public class MaybeLovesMe {
    private Random random = new Random();
    public void run() {
        System.out.println("Well, here goes nothing!");
        int petals = randomInt(13, 89);
        String s = "";
        int i = 1;
        while(i < petals) {
            if(petals % 2 == 0) {
                s = "It loves me not!";
            } else {
                s = "It loves me!";
            }
            System.out.println(s);
            i++;
        }
        if(s.equals("It loves me!")) {
            System.out.println("It really loves me!");
        } else {
            System.out.println("Aww, bummer.");
        }
    }
    
    public int randomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
