
package com.sg.findthecheesev2.game;

import Grid.Grid;
import com.sg.findthecheesev2.game.pieces.Cheese;
import com.sg.findthecheesev2.game.pieces.Goblin;
import com.sg.findthecheesev2.game.pieces.Mouse;
import com.sg.findthecheesev2.game.pieces.IPiece;
import com.sg.findthecheesev2.ui.UserIO;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    // static is owned by the class as a whole,
    // others are owned by the object.
    private static final int WIDTH = 10;
    
    // typically want to use abstractions when accepting values.
    // allows you to change your mind later on.
    private Grid grid;
    
    private final IPiece mouse;
    private final IPiece cheese;
    private final IPiece goblin;
    
    private boolean isWin;
    private boolean isGameOver;
    private boolean isCaught;
    private boolean isOutOfBounds;
    
    private final int cheeseMoveChance = 10;
    
    private Scanner sc;
    private UserIO io;
    
    
    public Game(UserIO io){
        sc = new Scanner(System.in);
        this.io = io;
        
        mouse = new Mouse();
        cheese = new Cheese();
        goblin = new Goblin();
        ArrayList<IPiece> pieces = new ArrayList<IPiece>(){{
            add(mouse);
            add(cheese);
            add(goblin);
        }};
        grid = new Grid(pieces, WIDTH);
        isWin = isGameOver = isCaught = isOutOfBounds = false;
    }
    
    public void run() {
        // add multiple cheeses, or
        // have to get next cheese.
        gameLoop();
        
        if(isOutOfBounds){
            System.out.println("Out of bounds! You lose.");
        } else if(isCaught){
            System.out.println("You got caught! You lose.");
        } else {
            System.out.println("You win! :D");
        }
    }
    
    private boolean isGameOver(){
        return false;
    }
    
    private boolean checkPlayerOutOfBounds(){
        return mouse.getX() < 0 || mouse.getX() >= WIDTH
                || mouse.getY() < 0 || mouse.getY() >= WIDTH;
    }
    
    private boolean checkPlayerIsCaught(){
        return mouse.getX() == goblin.getX()
                && mouse.getY() == goblin.getY();
    }
    
    private boolean checkPlayerWin(){
        int mouseX = mouse.getX();
        int mouseY = mouse.getY();
        int cheeseX = cheese.getX();
        int cheeseY = cheese.getY();
        return mouseX == cheeseX
                && mouseY == cheeseY;
    }

    private void gameLoop() {
        
    while(!isGameOver){
        int playerX = 0;
        int playerY = 0;
        print();
        
        switch(io.readChar("Move [WASD]:")){
            case 'W':
                playerY = mouse.getY() - 1;
                break;
            case 'A':
                playerX = mouse.getX() - 1;
                break;
            case 'S':
                playerY = mouse.getY() + 1;
                break;
            case 'D':
                playerX = mouse.getX() + 1;
                break;
            default:
                System.out.println("Invalid entry.");
        }
        boolean playerMoveValid = mouse.move(playerX, playerY);
        if(playerMoveValid){
            
            goblin.move(playerX, playerY);
            cheese.move(playerX, playerY);
        }
        isWin = checkPlayerWin();
        isCaught = checkPlayerIsCaught();
        isOutOfBounds = checkPlayerOutOfBounds();
        isGameOver = isWin || isCaught || isOutOfBounds;
        }
    }

    private void print() {
        grid.print();
    }

    
}
