package exercises4;

import java.util.Scanner;

public class KnockKnock {
    public void run() {
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Knock Knock! Guess who!! ");
        String nameGuess = inputReader.nextLine();
//        if I were to use == instead of .equals, then the program would compare the
//        place in memory and not the value of the string.
//        the capitalization can be fixed with string.toLower();
        if(nameGuess.equals("Marty McFly")){
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); // Sorry, had to!
        }else{
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
}
