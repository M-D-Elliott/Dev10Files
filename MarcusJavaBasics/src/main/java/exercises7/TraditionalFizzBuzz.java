
package exercises7;

import java.util.Scanner;

public class TraditionalFizzBuzz {
    private Scanner scanner = new Scanner(System.in);
    public void run() {
        run(3, 5);
    }
    
    public void run(int fizz, int buzz) {
        System.out.println("Give me the final number!");
        int value = scanner.nextInt(0);
        String ret = "";
        for(;value > 0; value--) {
            if(value % fizz == 0) {
                ret += "fizz";
            }
        }
    }
}
