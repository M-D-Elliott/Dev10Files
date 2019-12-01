package exercises10;

import Utils.InOutUtils;
import java.util.Scanner;

public class Factorizer {
    private boolean _isPlaying = true;
    
    public void run() {
        while(_isPlaying) {
            play();
            System.out.println("Play again? y/n");
            Scanner sc = new Scanner(System.in);
            _isPlaying = sc.nextLine().equalsIgnoreCase("y");
        }
    }
    
    private int moreThanZero(int i) {
        return (i < 1) ? 1 : i;
    }

    private void play() {
        int number = InOutUtils.readInt("What number would you like to factor?");
        int[] factors = new int[moreThanZero(number)];
        int halfOfNumber = (int)(number / 2);
        
        int arrayIndex = 0;
        for(int i = 1; i <= (halfOfNumber); i++) {
            if(number % i == 0) {
                factors[arrayIndex] = i;
                arrayIndex++;
            }
        }
        String factorsString = "";
        for(int factor : factors) {
            if(factor != 0) {
                factorsString += factor + ", ";
                System.out.println(factor);
            } else {
                break;
            }
        }
        
        String[] fixedFactors = factorsString.split(", ");
        
        boolean isPerfect = isPerfect(number, factors);
        String not = (isPerfect) ? "" : " not";
        System.out.println("This number is" + not + " perfect.");
        
        boolean isPrime = isPrime(fixedFactors);
        not = (isPrime) ? "" : " not";
        System.out.println("This number is" + not + " prime.");
    }
    
    private boolean isPrime(Object[] factors) {
        return factors.length == 1;
    }
    
    private boolean isPerfect(int number, int[] factors) {
        return sum(factors) == number;
//        if(sum(factors) == number) {
//            return true;
//        } else {
//            return false;
//        }
    }
    
    private int sum(int[] n) {
        int sum = 0;
        for(int i: n)
          sum+=i;
        return sum;
    }
}
