package Challenges;

import Utils.RandomUtils;
import java.util.Random;
import java.util.Scanner;

public class MontyHall {
    private final int doors = 3;
    private int wins = 0;
    private int losses = 0;
    
    public void run() {
        do {
            if(playGame()) {
                wins++;
            } else {
                losses++;
            }
        }while(readBoolean("Do you want to play again?"));
        
        printCareerTotals(wins, losses);
    }
    
    public void test() {
        String[] arr = new String[] {"Lol", "yes", "no", "hellow"};
        String item = (String)RandomUtils.getItem(arr);
        System.out.println(item);
    }

    private boolean readBoolean(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt + " y/n");
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    private int readDoor() {
        Scanner scanner = new Scanner(System.in);
        int door = 0;
        do {
            System.out.println("Player, pick a door. [1-3]");
            String input = scanner.nextLine();
            if(input.length() == 1) {
                char c = input.charAt(0);
                if(c == '1' || c == '2' || c == '3') {
                    // shift the value down so it is 0, 1, 2 of a char ---> int.
                    door = c - '1' + 1;
                }
                //equiv to:
                if(c == '1') {
                
                } else if(c == '2'){
                
                } else if(c == '3'){
                
                }
            }
        }while(door < 1 || door > 3);
        return door;
    }
    
    private boolean playGame() {
        int playerDoor = readDoor();
        
        int carDoor = RandomUtils.getInt(1, 3);
        
        
        int goatDoor = revealGoat(playerDoor, carDoor);
        if(readBoolean("Do you want to switch doors?")) {
            playerDoor = 3 - playerDoor - carDoor;
        }
        boolean win = playerDoor == carDoor;
        if(win) {
            System.out.println("You won the car!");
        } else {
            System.out.println("You won a goat!");
        }
        return win;
    }

    private int revealGoat(int playerDoor, int winningDoor) {
        Random rand = new Random();
        int goatDoor = 0;
        if(playerDoor == winningDoor) {
            if(rand.nextBoolean()){
                goatDoor = (playerDoor + 1) % 3;
            } else {
                goatDoor = (playerDoor + 2) % 3;
            }
        } else {
            goatDoor = (6 - playerDoor - winningDoor) % 3;
        }
        System.out.println("There's a goat behind door #" + goatDoor + 1);
        return goatDoor;
    }
    
    private void printCareerTotals(int wins, int losses) {
        System.out.println("Your Monty Hall Problem Totals");
        System.out.println("==============================");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("\n\nGoodbye");
    }
}
