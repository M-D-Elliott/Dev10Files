package com.sg.dentalclinic.ui;

public enum UserMenuOption {

    RETURN(0, "Return"),
    LOG_OUT(1, "Logout");

    private final int value;
    private final String name;

    private UserMenuOption(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static UserMenuOption fromValue(int value) {
        for (UserMenuOption mmo : UserMenuOption.values()) {
            if (mmo.getValue() == value) {
                return mmo;
            }
        }
        return RETURN;
    }
}
