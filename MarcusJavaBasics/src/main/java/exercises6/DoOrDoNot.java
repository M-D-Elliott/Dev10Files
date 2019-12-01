package exercises6;

import java.util.Scanner;

public class DoOrDoNot {
    public void run() {
        Scanner input = new Scanner(System.in);
        System.out.print("Should I do it? (y/n) ");
        boolean doIt;

        if (input.next().equals("y")) {
            doIt = true; // DO IT!
        } else {
            doIt = false; // DONT YOU DARE!
        }

        boolean iDidIt = false;

//        do {
//            iDidIt = true;
//            break;
//        } while (doIt);

//        with the while loop instead the y is the same, but the n goes to default.
        while (doIt) {
            iDidIt = true;
            break;
        }
        
        // the y answer caues the first response to fire.
        // the n answer causes the second response.
        // any other answer goes to the default.
        if (doIt && iDidIt) {
            System.out.println("I did it!");
        } else if (!doIt && iDidIt) {
            System.out.println("I know you said not to ... but I totally did anyways.");
        } else {
            System.out.println("Don't look at me, I didn't do anything!");
        }
    }
}
