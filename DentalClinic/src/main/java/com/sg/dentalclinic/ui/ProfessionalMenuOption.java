package com.sg.dentalclinic.ui;

public enum ProfessionalMenuOption {

    RETURN(0, "Return"),
    ADD_PROFESSIONAL(1, "Add a Dental Professional"),
    VIEW_APPOINTMENTS(2, "View a Professional's appointments");

    private final int value;
    private final String name;

    private ProfessionalMenuOption(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static ProfessionalMenuOption fromValue(int value) {
        for (ProfessionalMenuOption mmo : ProfessionalMenuOption.values()) {
            if (mmo.getValue() == value) {
                return mmo;
            }
        }
        return RETURN;
    }
}
