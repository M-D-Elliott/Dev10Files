package com.sg.dentalclinic.ui;

public enum CustomerMenuOption {

    RETURN(0, "Return"),
    ADD_CUSTOMER(1, "Add a new Customer"),
    SCHEDULE_APPOINTMENT(2, "Schedule an appointment");


    private final int value;
    private final String name;

    private CustomerMenuOption(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static CustomerMenuOption fromValue(int value) {
        for (CustomerMenuOption mmo : CustomerMenuOption.values()) {
            if (mmo.getValue() == value) {
                return mmo;
            }
        }
        return RETURN;
    }
}
