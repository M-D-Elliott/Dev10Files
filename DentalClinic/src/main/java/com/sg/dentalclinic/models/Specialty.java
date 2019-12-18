package com.sg.dentalclinic.models;

public enum Specialty {
    NULL(0, "NULL"),
    DENTIST(1, "Dentist"),
    HYGIENIST(2, "Hygienist"),
    ORTHODONTIST(3, "Orthodontist"),
    ORAL_SURGEON(4, "Oral_Surgeon");
    
    
    private final int value;
    private final String name;

    private Specialty(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static Specialty fromValue(int value) {
        for (Specialty mmo : Specialty.values()) {
            if (mmo.getValue() == value) {
                return mmo;
            }
        }
        return NULL;
    }
    
    public static Specialty fromName(String name) {
        for (Specialty mmo : Specialty.values()) {
            if (mmo.getName().equalsIgnoreCase(name)) {
                return mmo;
            }
        }
        return NULL;
    }
    
}
