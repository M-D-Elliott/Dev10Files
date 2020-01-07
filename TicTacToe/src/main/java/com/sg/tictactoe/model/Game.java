package com.sg.tictactoe.model;

import java.awt.Point;
import java.util.Arrays;

public class Game {
    private ObjectPoint[] emptyGrid;
    private ObjectPoint[] filledGrid;
    private int round;

    public Game() {
    }

    public ObjectPoint[] getEmptyGrid() {
        return emptyGrid;
    }

    public void setEmptyGrid(ObjectPoint[] emptyGrid) {
        this.emptyGrid = emptyGrid;
    }

    public ObjectPoint[] getFilledGrid() {
        return filledGrid;
    }

    public void setFilledGrid(ObjectPoint[] filledGrid) {
        this.filledGrid = filledGrid;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Arrays.deepHashCode(this.emptyGrid);
        hash = 83 * hash + Arrays.deepHashCode(this.filledGrid);
        hash = 83 * hash + this.round;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.round != other.round) {
            return false;
        }
        if (!Arrays.deepEquals(this.emptyGrid, other.emptyGrid)) {
            return false;
        }
        if (!Arrays.deepEquals(this.filledGrid, other.filledGrid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "emptyGrid=" + emptyGrid + ", filledGrid=" + filledGrid + ", round=" + round + '}';
    }
}
