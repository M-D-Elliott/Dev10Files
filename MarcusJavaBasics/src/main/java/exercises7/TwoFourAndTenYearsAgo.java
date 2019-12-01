package exercises7;

import java.util.Scanner;

public class TwoFourAndTenYearsAgo {
    public void run() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        // the ranges are 0 to 10 for this.
        // this one is clearer, but the other is more dynamic.
        // clearer because the ranges are hardcoded and predefined.
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));
        }

        System.out.println("\nI can count backwards using a different way too...");

        // the ranges are starting year to starting year - 10
        for (int i = year; i >= year - 20; i--) {
            System.out.println( (year - i) + " years ago would be " + i);
        }
    }
}
