package com.sg.tictactoe.model;

import java.awt.Point;

public class Board {

    private Character[][] grid;

    private int turn = 1;
    private Character winner;

    private static final Character EMPTY_VALUE = '-';
    private int size;
    
    private Character player1;
    private Character player2;

    public Board(int size) {
        this.size = size;
        reset();
    }

    public Character[][] getGrid() {
        return grid;
    }

    public void setGrid(Character[][] grid) {
        this.grid = grid;
    }
    
    public int getTurn() {
        return turn;
    }

    public void incTurn() {
        if(checkWin(new Point(2, 2))){
            winner = (turn % 2 == 0) ? player2 : player1;
        }
        turn++;
    }

    public void reset() {
        turn = 1;
        this.grid = new Character[size][size];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = EMPTY_VALUE;
            }
        }
    }

    public Character getWinner() {
        return winner;
    }

    public void setWinner(Character winner) {
        this.winner = winner;
    }
    
     private boolean check(Point p, int xAdd, int yAdd) {
        int x = p.x;
        int y = p.y;
        Character symbol = (turn % 2 == 0) ? player2 : player1;
        for(int i = 0; i < size; i++){
            Character symbolBeingChecked = grid[x + xAdd * i][y + yAdd * i];
            if(!symbolBeingChecked.equals(symbol)) {
                return false;
            }
        }
        return true;
    }
    
    // couldn't think of a better way!
    // didn't want to use tutorials, though
    // a better algorithm certainly exists.
    private boolean checkWin(Point p) {
        int x = p.x;
        int y = p.y;
        int checkRight = x + size;
        int checkLeft = x - size;
        int checkDown = y + size;
        int checkUp = y - size;
        if(checkRight < size - 1){
            if(check(p, 1, 0)) {return true;}
            if(checkDown < size - 1){
                if(check(p, 1, 1)) {return true;}
            }
            if(checkUp > 0){
                if(check(p, 1, -1)) {return true;}
            }
        }
        if(checkLeft > 0) {
            if(check(p, -1, 0)) {return true;}
            if(checkDown < size - 1){
                if(check(p, -1, 1)) {return true;}
            }
            if(checkUp > 0){
                if(check(p, 1, 1)) {return true;}
            }
        }
        if(checkDown < size - 1){
            if(check(p, 0, 1)) {return true;}
        }
        return false;
    }

}
