
package com.sg.findthecheesev2.game.pieces;

public class Mouse extends Piece {
    public Mouse(){
        super('M');
    }
    
    @Override
    public boolean move(int playerX, int playerY) {
        if(playerX != this.getX() || playerY != this.getY()){
            this.setX(playerX);
            this.setY(playerY);
            return true;
        }

        return false;
    }
}
