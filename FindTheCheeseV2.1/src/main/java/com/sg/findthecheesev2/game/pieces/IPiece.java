/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.findthecheesev2.game.pieces;


public interface IPiece {

    char getSymbol();

    int getX();

    int getY();

    void setSymbol(char symbol);

    void setX(int x);

    void setY(int y);
    
    boolean move(int playerX, int playerY);
}
