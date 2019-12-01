
package exercises5;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FortuneCookie {
    private List<String> fortunes = Arrays.asList("Those aren't the droids.",
                                                  "Never go in against a Sicilian",
                                                  "Goonies never say die.",
                                                  "With great power must also come great.",
                                                  "Never argue with the data.",
                                                  "Try not",
                                                  "You are a leaf in the wind",
                                                  "Do absolutely nothing",
                                                  "Kneel before zod",
                                                  "Make it so");
    private Random _random = new Random();
    public void run() {
        System.out.println(fortunes.get(getRandomInt(fortunes.toArray().length)));
    }
    
    public int getRandomInt(int max) {
        return _random.nextInt(max);
    }
}
