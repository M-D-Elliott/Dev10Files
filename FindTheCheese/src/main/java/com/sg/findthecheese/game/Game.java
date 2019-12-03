
package com.sg.findthecheese.game;

import com.sg.findthecheese.game.pieces.Cheese;
import com.sg.findthecheese.game.pieces.Goblin;
import com.sg.findthecheese.game.pieces.Mouse;
import com.sg.findthecheese.game.pieces.Piece;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    // static is owned by the class as a whole,
    // others are owned by the object.
    private static final int WIDTH = 10;
    
    // typically want to use abstractions when accepting values.
    // allows you to change your mind later on.
    private ArrayList<Piece> pieces = new ArrayList<>();
    
    private final Mouse mouse;
    private final Cheese cheese;
    private final Goblin goblin;
    
    private final int cheeseMoveChance = 10;
    
    private Scanner sc = new Scanner(System.in);
    
    public Game(){
        Random r = new Random();
        int x = r.nextInt(WIDTH);
        int y = r.nextInt(WIDTH);
        
        mouse = new Mouse();
        mouse.setX(x);
        mouse.setY(y);
        
        pieces.add(mouse);
        
        do{
            x = r.nextInt(WIDTH);
            y = r.nextInt(WIDTH);
        } while(x == mouse.getX() && y == mouse.getY());
        
        cheese = new Cheese();
        cheese.setX(x);
        cheese.setY(y);
        
        pieces.add(cheese);
        
        do{
            x = r.nextInt(WIDTH);
            y = r.nextInt(WIDTH);
        }while(x == mouse.getX() && y == mouse.getY()
                && x == cheese.getX() && y == cheese.getY());
        
        goblin = new Goblin();
        goblin.setX(x);
        goblin.setY(y);
        
        pieces.add(goblin);
    }
    
    public void run() {
        // add multiple cheeses, or
        // have to get next cheese.
        gameLoop();
        
        if(isLoss()){
            System.out.println("Out of bounds! You lose.");
        } else if(isCaught()){
            System.out.println("You got caught! You lose.");
        } else {
            System.out.println("You win! :D");
        }
    }
    
    private boolean isGameOver(){
        return false;
    }
    
    private boolean isLoss(){
        return mouse.getX() < 0 || mouse.getX() >= WIDTH
                || mouse.getY() < 0 || mouse.getY() >= WIDTH;
    }
    
    private boolean isCaught(){
        return mouse.getX() == goblin.getX()
                && mouse.getY() == goblin.getY();
    }
    
    private boolean isWin(){
        int mouseX = mouse.getX();
        int mouseY = mouse.getY();
        int cheeseX = cheese.getX();
        int cheeseY = cheese.getY();
        return mouseX == cheeseX
                && mouseY == cheeseY;
    }

    private void gameLoop() {
        boolean loss = isLoss();
        boolean win = isWin();
        boolean caught = isCaught();
        
        while(!loss || !win || !caught){
            loss = isLoss();
            win = isWin();
            caught = isCaught();
            if(loss || win || caught){
                break;
            }
            print();
            boolean playerMoveValid = playerMove();
            if(playerMoveValid){
                goblinMove();
                cheeseMove();
            }
        }
    }
    
    private boolean playerMove(){
        System.out.println("Move [WASD]:");
        switch(sc.nextLine()){
            case "W":
                mouse.setY(mouse.getY() - 1);
                break;
            case "A":
                mouse.setX(mouse.getX() - 1);
                break;
            case "S":
                mouse.setY(mouse.getY() + 1);
                break;
            case "D":
                mouse.setX(mouse.getX() + 1);
                break;
            default:
                System.out.println("Invalid entry.");
                return false;
        }
        return true;
    }
    
    private void goblinMove(){
        if(mouse.getX() < goblin.getX()){
            goblin.setX(goblin.getX() - 1);
        } else if(mouse.getX() > goblin.getX()){
            goblin.setX(goblin.getX() + 1);
        } else if(mouse.getY() > goblin.getY()){
            goblin.setX(goblin.getY() + 1);
        } else if(mouse.getY() < goblin.getY()){
            goblin.setY(goblin.getY() - 1);
        }
    }
    
    private void cheeseMove(){
        Random random = new Random();
        int cheeseMoves = random.nextInt(cheeseMoveChance + 1);
        if(cheeseMoves >= cheeseMoveChance){
            int x = 0;
            int y = 0;
            do{
                x = random.nextInt(WIDTH);
                y = random.nextInt(WIDTH);
            }while(x == mouse.getX() && y == mouse.getY()
                    && x == goblin.getX() && y == goblin.getY());

            cheese.setX(x);
            cheese.setY(y);
        }
    }

    private void print() {
        for (int row = 0; row < WIDTH; row++) {
            for (int col = 0; col < WIDTH; col++) {
                boolean found = false;
                for (Piece piece : pieces) {
                    if(piece.getX() == col && piece.getY() == row){
                        found = true;
                        System.out.print(piece.getSymbol());
                    }
                }
                
                if(!found){
                    System.out.print("_");
                }
            }
            System.out.println("");
        }
    }
}
