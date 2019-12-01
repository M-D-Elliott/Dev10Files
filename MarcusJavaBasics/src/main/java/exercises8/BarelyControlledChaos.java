package exercises8;

import java.util.Random;

public class BarelyControlledChaos {
    Random _random = new Random();
    private String[] _colors = new String[5];
    private String[] _animals = new String[5];
    public void run() {
        fillColors();
        fillAnimasl();
        String color = color(); // call color method here 
        String animal = animal(); // call animal method again here 
        String colorAgain = color(); // call color method again here 
        int weight = number(5, 200); // call number method, 
            // with a range between 5 - 200 
        int distance = number(-20, 10); // call number method, 
            // with a range between 10 - 20 
        int number = number(10000, 20000); // call number method, 
            // with a range between 10000 - 20000 
        int time = number(2, 6); // call number method, 
            // with a range between 2 - 6            
    
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    } 
    
    public String color(){
        return _colors[number(0, _colors.length)];
    }

    private String animal() {
        return _animals[number(0, _animals.length)];
    }

    private int number(int min, int max) {
        return _random.nextInt(max - min + 1) + min;
    }

    private void fillColors() {
        _colors[0] = "green";
        _colors[1] = "red";
        _colors[2] = "blue";
        _colors[3] = "purple";
        _colors[4] = "orange";
    }

    private void fillAnimasl() {
        _animals[0] = "turkey";
        _animals[1] = "pig";
        _animals[2] = "cow";
        _animals[3] = "moose";
        _animals[4] = "zebra";
    }
}
