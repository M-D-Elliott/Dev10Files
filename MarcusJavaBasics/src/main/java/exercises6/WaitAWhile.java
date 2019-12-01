package exercises6;

public class WaitAWhile {
    public void run() {
//        if time now exceeds bedtime the person will go to bed immediately
        int timeNow = 5;
        // the person will stay up an extra hour if bedtime is 11 instead of 10.
        int bedTime = 11;

        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer....");
            // if timeNow ++ is removed the loop will run indefinitely
            timeNow++; // Time passes
        }

        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
    }
}
