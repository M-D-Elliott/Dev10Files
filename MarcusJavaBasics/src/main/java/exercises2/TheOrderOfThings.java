
package exercises2;

public class TheOrderOfThings {
    public void run() {
        double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;
        
        number = 5.0;
        opinion = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "yellow";
        origin = "Alpha-Centurian";
        material = "platinum";
        purpose = "good";
        
        noun = "dragon";
        
        // When you use + with string, 
        // Java concatenates (e.g., string them toegether) 
        // them instead of adding them.
        
        System.out.println(number + " " + opinion + " " + size + " " + age + " " + shape
        + " " + color + " " + origin + " " + material + " " + purpose + " " + noun
        );
    }
}
