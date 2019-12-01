package exercises9;

import java.util.Arrays;

public class FruitSalad {
    public void run() {
        String[] fruits = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        int maxFruits = 12;
        String[] fruitSalad = new String[maxFruits];
        int i = 0;
        int apples = 0;
        int oranges = 0;
        for(String fruit : fruits){
            if(i < maxFruits) {
                if(fruit.toLowerCase().contains("berry")) {
                    fruitSalad[i] = fruit;
                    i++;
                } else if(fruit.toLowerCase().contains("apple")){
                    if(apples < 3) {
                        fruitSalad[i] = fruit;
                        i++;
                        apples++;
                    }
                } else if(fruit.toLowerCase().contains("orange")){
                    if(oranges < 2) {
                        fruitSalad[i] = fruit;
                        i++;
                        oranges++;
                    }
                } else if(!fruit.toLowerCase().contains("tomato")){
                    fruitSalad[i] = fruit;
                    i++;
                }
            }
        }
        System.out.println(fruitSalad.length);
        System.out.println(Arrays.toString(fruitSalad));
    }
}
