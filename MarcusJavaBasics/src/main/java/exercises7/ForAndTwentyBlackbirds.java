package exercises7;

public class ForAndTwentyBlackbirds {
    public void run() {
        // changed maxbirds to 24 for tradition sake.
        int maxBirds = 24;
//        started i at 1 and eliminated birds in pie variable for simplicity.
        int i = 1;
        for (; i < maxBirds; i++) {
            System.out.println("Blackbird #" + i + " goes into the pie!");
        }

        System.out.println("There are " + i + " birds in there!");
        System.out.println("Quite the pie full!");
    }
}
