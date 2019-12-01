package exercises7;

import java.util.Scanner;

public class TheCount {
    private Scanner sc = new Scanner(System.in);
    public void run() {
        String string = "";
        int adds = 0;
        int start = readIntInput("Start:");
        int max = readIntInput("Stop at:");
        int by = readIntInput("Count by:");
        for(int count = start; count <= max; count += by) {
            string += count + " ";
            adds++;
            if(adds == 3) {
                string += " - Ah, Ah, Ah!\n";
                adds = 0;
            }
        }
        System.out.println(string);
    }
    
    public int readIntInput(String prompt) {
        System.out.println(prompt + " ");
        return sc.nextInt();
    }
}
