package lesson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notes1127 {
    public void run(){
        Map<String, List<Dog>> dogs = new HashMap<>();
        Dog d = new Dog("Beast", "Labrador Retreiver");
        
        List<Dog> dogList = new ArrayList<>();
        
        dogList.add(d);
        dogs.put("Firstdog", dogList);
        
        Dog d2 = new Dog("Lassie", "LassieDog");
        dogs.get("FirstDog").add(d2);
        
        System.out.println(dogs.get("FirstDog").size());
    }
}
