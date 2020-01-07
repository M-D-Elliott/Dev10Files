package com.sg.tictactoe.model;

public class Board {

    private Character[][] grid;

    private int turn = 0;
    private Character winner;

    private static final Character EMPTY_VALUE = '-';
    private int size;

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
        turn++;
    }

    public void reset() {
        turn = 0;
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

}
