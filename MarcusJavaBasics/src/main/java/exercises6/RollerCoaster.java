package exercises6;

import java.util.Scanner;

public class RollerCoaster {
    public void run() {
        
        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");

        String keepRiding = "y";
        int loopsLooped = 0;
        // if we check for an n then the question is inverted.
        // lol! this torments those who want to get off and
        // stops the fun for those who want to ride!
        while (keepRiding.equals("y")) {
            System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee.....!!!");
            System.out.print("Want to keep going? (y/n) :");
            keepRiding = userInput.nextLine();
            // loopsLooped does not need to be reinitialized, which
            // is why it is not given the int keyword beforehand.
            loopsLooped++;
        }

        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped + " times!!");
    }
}
