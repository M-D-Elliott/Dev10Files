package exercises9;

import java.util.HashMap;
import java.util.Map;

public class FruitsBasket {
    public void run() {
        String[] fruits = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        countSort(fruits);
    }

    public void countSort(String[] array) {
        Map<String, Integer> count = new HashMap<>();
        count.put("starter", 1);
        for(String item : array){
            count.keySet().forEach((key) -> {
                if (key.equals(item)){
                    int newCount = count.get(key) + 1;
                    count.replace(key, newCount);
                } else {
                    count.put(item, 1);
                }
            });
        }
        for(String key : count.keySet()){
            if(key.equalsIgnoreCase("starter")) {
                System.out.println("There are " + count.get(key) + " " + key + "s");
            }
        }
    }
}
