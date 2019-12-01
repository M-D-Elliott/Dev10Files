
package exercises6;

public class Countdown {
    public void run() {
        run(50);
    }
    public void run(int max) {
        String ret = "";
        for(int count = max;count > 0; count--) {
            String countAsString = Integer.toString(count);
            if(countAsString.length() < 2) {
                countAsString = "0" + countAsString;
            }
            ret += countAsString + " ";
            if((max - count + 1) % 10 == 0 && max != count) {
                ret += "\n";
            }
        }
        System.out.println(ret);
    }
}
