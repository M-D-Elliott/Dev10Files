package com.sg.tictactoe.model;

import java.awt.Point;
import java.util.Objects;

public class ObjectPoint <T> extends Point {
    private T object;

    public ObjectPoint(T object) {
        this.object = object;
    }

    public ObjectPoint(T object, Point p) {
        super(p);
        this.object = object;
    }

    public ObjectPoint(T object, int x, int y) {
        super(x, y);
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.object);
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
        final ObjectPoint<?> other = (ObjectPoint<?>) obj;
        if (!Objects.equals(this.object, other.object)) {
            return false;
        }
        return true;
    }
    
}
