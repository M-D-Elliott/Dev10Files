
package com.sg.findthecheese.game.pieces;

//to prevent instantiation of this.
// only new keyword is instantiation.
public abstract class Piece {
    
    private int x;
    private int y;
    private char symbol;

    public Piece(char symbol) {
        this.symbol = symbol;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
