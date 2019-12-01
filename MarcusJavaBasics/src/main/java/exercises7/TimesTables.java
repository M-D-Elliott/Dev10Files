package exercises7;

import java.util.Scanner;

public class TimesTables {
    private Scanner sc = new Scanner(System.in);
    public void run() {
        int number = readIntInput("What times table shall I recite?");
        for(int i = 1; i <= 15; i++) {
            System.out.println(i + " * " + number + " is " + number * i);
        }
    }
    
    public int readIntInput(String prompt) {
        System.out.println(prompt + " ");
        return sc.nextInt();
    }
}
