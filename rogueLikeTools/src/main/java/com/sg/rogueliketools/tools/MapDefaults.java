package com.sg.rogueliketools.tools;

public enum MapDefaults {
    NULL(0, '-'),
    FLOOR(1, '.'),
    DOOR(2, 'D'),
    WALL(3, '#');
    
    private final int ID;
    private final char value;

    private MapDefaults(int ID, char value) {
        this.ID = ID;
        this.value = value;
    }

    public int getID() {
        return ID;
    }

    public char getValue() {
        return value;
    }

    public static MapDefaults fromValue(int id) {
        for (MapDefaults md : MapDefaults.values()) {
            if (md.getID() == id) {
                return md;
            }
        }
        return NULL;
    }
}