package Units;

public class PrintDivisibleByInput {
    public void run(int max, int by) {
        String string = "";
        for(int count = 1; count <= max; count++) {
            if(count % by == 0) {
                string += count + ", ";
            }
        }
        System.out.println(string);
    }
}
