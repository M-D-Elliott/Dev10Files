package exercises7;

public class SpringForwardFallBack {
    public void run() {
        System.out.println("It's Spring...!");
        // starts at 0, ends at 9.
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + ", ");
        }

        System.out.println("\nOh no, it's fall...");
        // starts at 10, ends at 1.
        for (int i = 10; i > 0; i--) {
            System.out.print(i + ", ");
        }
    }
}
