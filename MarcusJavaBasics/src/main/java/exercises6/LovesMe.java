package exercises6;

public class LovesMe {
    public void run() {
        System.out.println("Well, here goes nothing!");
        int petals = 34;
        while(petals > 0) {
            if(petals % 2 == 0) {
                System.out.println("It loves me not!");
            } else {
                System.out.println("It loves me!");
            }
            petals--;
        }
        System.out.println("I knew it! It loves me!");
    }
}
