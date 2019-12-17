package com.sg.dentalclinic.ui;

public enum AppointmentMenuOption {

    RETURN(0, "Return"),
    VIEW_BY_DAY_AND_DENTIST(1, "View appointments by day and Professional"),
    VIEW_BY_DAY_AND_CUSTOMER(2, "View appointments by day and Customer"),
    UPDATE_APPOINTMENT(3, "Update existing appointment"),
    CANCEL_APPOINTMENT(4, "Cancel existing appointment");

    private final int value;
    private final String name;

    private AppointmentMenuOption(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static AppointmentMenuOption fromValue(int value) {
        for (AppointmentMenuOption mmo : AppointmentMenuOption.values()) {
            if (mmo.getValue() == value) {
                return mmo;
            }
        }
        return RETURN;
    }
}
