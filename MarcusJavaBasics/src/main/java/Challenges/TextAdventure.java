package Challenges;

import java.util.Scanner;

public class TextAdventure {
    private static int _room = 0;
    private static boolean _hasItem1 = false;
    private static boolean _hasItem2 = false;
    private static boolean _isPlaying = true;
    private static String _choice;
    
    public void run() {
        reset();
        Scanner scanner = new Scanner(System.in);
        
        _choice = "";
        while(_isPlaying) {
            if(_hasItem1) {
                System.out.println("You have the ring.");
            }
            if(_hasItem2) {
                System.out.println("You have the ball.");
            }
            
            switch (_room) {
                case 0:
                    System.out.println("You are outside the house.");
                    System.out.println("You can go *upstairs*, *downstairs*, or *inside*.");
                    _choice = scanner.nextLine();
                switch (_choice) {
                    case "downstairs":
                        _room = 1;
                        break;
                    case "upstairs":
                        _room = 2;
                        break;
                    case "inside":
                        _room = 3;
                        break;
                    default:
                        System.out.println("I don't understand");
                        break;
                }
                break;

                case 1:
                    System.out.println("You are downstairs");
                    if(!_hasItem1) {
                        System.out.println("You see a ring. Pick it up? y/n");
                        _choice = scanner.nextLine();
                        if(_choice.equals("y")) {
                            _hasItem1 = true;
                            System.out.println("You pick up the ring");
                        } else {
                            System.out.println("You leave the ring where it is.");
                        }
                    } else {
                        System.out.println("You see nothing else.");
                    }   System.out.println("You can go *upstairs* to the outside.");
                    _choice = scanner.nextLine();
                    if(_choice.equals("upstairs")) {
                        _room = 0;
                    } else {
                        System.out.println("I don't understand");
                    }   break;
                case 2:
                    System.out.println("You are upstairs.");
                    if(!_hasItem2) {
                        System.out.println("You see a ball. Pick it up? y/n");
                        _choice = scanner.nextLine();
                        if(_choice.equals("y")) {
                            _hasItem2 = true;
                            System.out.println("You pick up the ball");
                        } else {
                            System.out.println("You leave the ball where it is.");
                        }
                    } else {
                        System.out.println("You see nothing else.");
                    }   System.out.println("You can go *downstairs* to the outside.");
                    _choice = scanner.nextLine();
                    if(_choice.equals("downstairs")) {
                        _room = 0;
                    } else {
                        System.out.println("I don't understand");
                    }   break;
                case 3:
                    System.out.println("You are inside the house.");
                    if(_hasItem1 && _hasItem2) {
                        System.out.println("You win!");
                    } else { // lose condition
                        System.out.println("You have no items to protect you.");
                        System.out.println("You were eaten by a grue. You lose!");
                        System.out.println("Hint: you need a ring and a ball.");
                    }   System.out.println("Play again? y/n");
                    _choice = scanner.nextLine();
                    if(!_choice.equals("y")) {
                        _isPlaying = false;
                    } else {
                        reset();
                    }   break;
                default:
                    break;
            }
            _choice = "";
        }
    }
    
    public static void resetPublic() {
        reset();
    }
    
    private static void reset() {
        reset("You reset the game");
    }
    
    private static void reset(String message) {
        System.out.println(message);
        _room = 0;
        //this is the same as hasItem1 = false, hasItem2 = false.
        _hasItem1 = _hasItem2 = false;
        _isPlaying = true;
    }
}
