package exercises7;

import java.util.Scanner;

public class TimesTableCheck {
    private Scanner sc = new Scanner(System.in);
    public void run() {
        int number = readIntInput("What times table shall I recite?");
        int points = 0;
        for(int i = 1; i <= 15; i++) {
            int answer = readIntInput(i + " * " + number + " is?");
            if(answer == number * i) {
                System.out.println("Correct!");
                points++;
            }
        }
        if(points / 15 < 0.50) {
            System.out.println("You should study more!");
        } else if (points / 15 > 0.90) {
            System.out.println("Congrats on your A!");
        } else {
            System.out.println("You passed!");
        }
    }
    
    public int readIntInput(String prompt) {
        System.out.println(prompt + " ");
        return sc.nextInt();
    }
}
