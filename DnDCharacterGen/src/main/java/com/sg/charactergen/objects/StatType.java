package com.sg.charactergen.objects;

public enum StatType {
    STRENGTH(0, "str"),
    DEXTERITY(1, "dex"),
    CONSTITUTION(2, "con"),
    INTELLIGENCE(3, "int"),
    WISDOM(4, "wis"),
    CHARISMA(5, "chr");
    
    private final int value;
    private final String name;

    private StatType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static StatType fromValue(int value) {
        for (StatType mmo : StatType.values()) {
            if (mmo.getValue() == value) {
                return mmo;
            }
        }
        return STRENGTH;
    }
}
