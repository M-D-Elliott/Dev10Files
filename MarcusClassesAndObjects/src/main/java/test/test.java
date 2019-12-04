package test;

import java.util.HashMap;
import java.util.Map;

public class test {
    public void run(){
        Map<String, String> foodCombos = new HashMap<>();
        foodCombos.put("PeanutButter","Jelly");
        foodCombos.put("Mac","Cheese");
        foodCombos.put("Ham","Cheese");
        foodCombos.put("Fish","Chips");
        foodCombos.put("Chicken","Waffles");
        String whatAmI = foodCombos.get("Cheese");
        System.out.println(whatAmI);
        
        Huggable john = new Husky();
        Trainable jake = new Husky();
    }
}
