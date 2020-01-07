package com.sg.tictactoe.model;

import java.awt.Point;
import java.util.Objects;

public class Play {
    private Character side;
    private Point position;

    public Play(Character side, Point position) {
        this.side = side;
        this.position = position;
    }

    public Character getSide() {
        return side;
    }

    public void setSide(Character side) {
        this.side = side;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition (Point position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.side);
        hash = 53 * hash + Objects.hashCode(this.position);
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
        final Play other = (Play) obj;
        if (!Objects.equals(this.side, other.side)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Play{" + "side=" + side + ", position=" + position + '}';
    }
}
