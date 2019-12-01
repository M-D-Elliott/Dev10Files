package Challenges;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountSortExample {
    public void run() {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        
        List<String> ls = Arrays.asList(fruit);
        
        Collections.shuffle(ls);
        
//        fruit = ls.toArray();
        
        String[] fruitSalad = new String[12];
        
        int saladIndex = 0;
        for (String f : fruit) {
            if(saladIndex >= fruitSalad.length) {
                break;
            }
            // because add as many berries as possible, must be checked first.
            if(f.contains("berry")){
                fruitSalad[saladIndex] = f;
                saladIndex++;
            }
        }
        
        int appleCount = 0;
        int orangeCount = 0;
        
        for (String f : fruit) {
            if(saladIndex >= fruitSalad.length) {
                break;
            }
            if(appleCount < 3 && f.contains("Apples")){
                fruitSalad[saladIndex] = f;
                saladIndex++;
                appleCount++;
            } else if(orangeCount < 2 && f.contains("Orange")) {
                fruitSalad[saladIndex] = f;
                saladIndex++;
                orangeCount++;
            } else if(!f.contains("Tomato") && !f.contains("berry") && !f.contains("Orange") && !f.contains("Apple")) {
                fruitSalad[saladIndex] = f;
                saladIndex++;
            }
        }
        
        for (String f : fruitSalad) {
            System.out.println(f);
        }
    }
}
