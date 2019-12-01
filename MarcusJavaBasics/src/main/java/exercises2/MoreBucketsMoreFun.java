package exercises2;

public class MoreBucketsMoreFun {

    public void run() {
        // Declare ALL THE THINGS
        // (Usually it's a good idea to declare them at the beginning of the program)
        int butterflies, beetles, bugs;
        String color, size, shape, thing;
        double number;
        
        // Now give a couple of them some values
        
        butterflies = 2;
        beetles = 4;
        
        bugs = butterflies + beetles;
        
        System.out.println("There are only " + butterflies + " butterflies," );
        System.out.println("but " + bugs + " bugs total.");
        
        System.out.println("Uh oh, my dog at one.");
//        the unary subtraction operator removes one from the
//        butterflies, showing a dog ate one.
        butterflies--;
        System.out.println("Now there are only " + butterflies + " butterfleis left.");
        System.out.println("But still " + bugs + " bugs left, wait a minute!!!");
        System.out.println("Maybe I just counted wrong the first time...");
    }
    
}
