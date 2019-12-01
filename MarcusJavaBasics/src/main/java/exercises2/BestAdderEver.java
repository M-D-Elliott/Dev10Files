package exercises2;

import java.util.Scanner;

public class BestAdderEver {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First number: ");
        int first = scanner.nextInt();
        System.out.println("Second number: ");
        int second = scanner.nextInt();
        System.out.println("Third number: ");
        int third = scanner.nextInt();
        
        int res = first + second + third;
        System.out.println(res);
        System.out.println(res);
    }
    
}
