package Units;

import java.util.Random;

public class RandomTest {
    public void run(int numTimes) {
        for(;numTimes > 0; numTimes--)
        {
            Random random = new Random();
            // without the addition of 1 the generator will also create a 0,
//            effectively limiting the range of the random generator
            int n = random.nextInt(10) + 1;
            System.out.println(n);
        }

    }
}
