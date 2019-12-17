package com.sg.dentalclinic.ui;

public enum MainMenuOption {

    EXIT(0, "Exit"),
    APPOINTMENT_MENU(1, "Appointments"),
    CUSTOMER_MENU(2, "Customers"),
    PROFESSIONAL_MENU(3, "Professionals"),
    USER_MENU(4, "Users");

    private final int value;
    private final String name;

    private MainMenuOption(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static MainMenuOption fromValue(int value) {
        for (MainMenuOption mmo : MainMenuOption.values()) {
            if (mmo.getValue() == value) {
                return mmo;
            }
        }
        return EXIT;
    }
}
