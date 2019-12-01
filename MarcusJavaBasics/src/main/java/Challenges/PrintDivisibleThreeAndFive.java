
package Challenges;

public class PrintDivisibleThreeAndFive {
    private String threes = "";
    private String fives = "";
    public void run(int max) {
        for(int count = 1; count <= max; count++) {
            if(count % 3 == 0) {
                threes += count + ", ";
            }
            if(count % 5 == 0) {
                fives += count + ", ";
            }
        }
        System.out.println(threes);
        System.out.println(fives);
    }       
}
