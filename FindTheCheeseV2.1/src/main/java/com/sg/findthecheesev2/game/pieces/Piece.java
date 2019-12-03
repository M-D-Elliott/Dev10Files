
package com.sg.findthecheesev2.game.pieces;

//to prevent instantiation of this.
// only new keyword is instantiation.
public abstract class Piece implements IPiece {
    
    private int x;
    private int y;
    private char symbol;

    public Piece(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
