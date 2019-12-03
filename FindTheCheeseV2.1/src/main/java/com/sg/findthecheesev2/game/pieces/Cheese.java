
package com.sg.findthecheesev2.game.pieces;

import java.util.Random;

public class Cheese extends Piece {
    private int cheeseMoveChance;
    
    private int arenaWidth;
    
    public Cheese(){
        super('C');
    }

    public Cheese(char symbol) {
        super(symbol);
    }

    public Cheese(int cheeseMoveChance, char symbol, int arenaWidth) {
        super(symbol);
        this.cheeseMoveChance = cheeseMoveChance;
        this.arenaWidth = arenaWidth;
    }

    @Override
    public boolean move(int playerX, int playerY) {
        Random random = new Random();
        int cheeseMoves = random.nextInt(cheeseMoveChance + 1);
//        if(cheeseMoves >= cheeseMoveChance){
//            int x = 0;
//            int y = 0;
//            do{
//                x = random.nextInt(arenaWidth);
//                y = random.nextInt(arenaWidth);
//            }while(x == mouse.getX() && y == mouse.getY()
//                    && x == goblin.getX() && y == goblin.getY());
//
//            super.move();
//        }
        return true;
    }
}
