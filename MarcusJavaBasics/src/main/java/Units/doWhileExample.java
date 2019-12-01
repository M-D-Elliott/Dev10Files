package Units;

import java.util.Scanner;

public class doWhileExample {
    public void run() {
        String input = null;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter an integer: ");
            int n = scanner.nextInt();
//            consumes the new line left over
            scanner.nextLine();
            System.out.println("n is: " + n);
            
            System.out.println("Enter a string: ");
            input = scanner.nextLine();
            System.out.println("Value: " + input);
            
        }while(!input.equals("exit"));
    }
}
