package com.sg.dentalclinic.ui;

import com.sg.dentalclinic.models.Professional;
import com.sg.dentalclinic.service.Response;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View {
    // IO class, for composition
    private UserIO io;
    
    // banner for encasing certain titles
    // specifically for clinic family dentistry (kinda! ;o).
    private static final String LEFT_BANNER = " ===";
    private static final String RIGHT_BANNER = "=== ";

    public View(UserIO io) {
        this.io = io;
    }

    // * * * * * * * * * * * MENU PRINT/SELECTION * * * * * * * * * * * * 
    
    public MainMenuOption selectFromMainMenu() {
        int min = 0;
        int max = (int)MainMenuOption.values().length - 1;
        for (MainMenuOption mmo : MainMenuOption.values()) {
            io.print(String.format("%s. %s", mmo.getValue(), mmo.getName()));
            min = Math.min(mmo.getValue(), min);
            max = Math.max(mmo.getValue(), max);
        }
        int value = readMenuSelection(min, max);
        return MainMenuOption.fromValue(value);
    }
    
    public AppointmentMenuOption selectFromAppointmentMenu() {
        int min = 0;
        int max = (int)AppointmentMenuOption.values().length - 1;
        for (AppointmentMenuOption mmo : AppointmentMenuOption.values()) {
            io.print(String.format("%s. %s", mmo.getValue(), mmo.getName()));
            min = Math.min(mmo.getValue(), min);
            max = Math.max(mmo.getValue(), max);
        }
        int value = readMenuSelection(min, max);
        return AppointmentMenuOption.fromValue(value);
    }
    
    public CustomerMenuOption selectFromCustomerMenu() {
        int min = 0;
        int max = (int)CustomerMenuOption.values().length - 1;
        for (CustomerMenuOption mmo : CustomerMenuOption.values()) {
            io.print(String.format("%s. %s", mmo.getValue(), mmo.getName()));
            min = Math.min(mmo.getValue(), min);
            max = Math.max(mmo.getValue(), max);
        }
        int value = readMenuSelection(min, max);
        return CustomerMenuOption.fromValue(value);
    }
    
    public ProfessionalMenuOption selectFromProfessionalMenu() {
        int min = 0;
        int max = (int)ProfessionalMenuOption.values().length - 1;
        for (ProfessionalMenuOption mmo : ProfessionalMenuOption.values()) {
            io.print(String.format("%s. %s", mmo.getValue(), mmo.getName()));
            min = Math.min(mmo.getValue(), min);
            max = Math.max(mmo.getValue(), max);
        }
        int value = readMenuSelection(min, max);
        return ProfessionalMenuOption.fromValue(value);
    }
    
    public UserMenuOption selectFromUserMenu() {
        int min = 0;
        int max = (int)UserMenuOption.values().length - 1;
        for (UserMenuOption mmo : UserMenuOption.values()) {
            io.print(String.format("%s. %s", mmo.getValue(), mmo.getName()));
            min = Math.min(mmo.getValue(), min);
            max = Math.max(mmo.getValue(), max);
        }
        int value = readMenuSelection(min, max);
        return UserMenuOption.fromValue(value);
    }

    // * * * * * * * * * * * USER INPUT * * * * * * * * * * * * 
    
    private int readMenuSelection(int min, int max) {
        io.print("");
        int value = io.readInt(String.format("Select [%s-%s]:", min, max), min, max);
        return value;
    }
    
//    Professional readProfessional() {
//        return new Professional();
//    }

    LocalDate readDate() {
        return LocalDate.now();
    }
    
    public boolean shouldCreateCustomer(String header) {
        printHeader(header);
        io.print("1. Create a new customer.");
        io.print("2. Search for an existing customer.");
        return io.readInt("Select [1-2]: ", 1, 2) == 1;
    }
    
    public String getLastNameSearch() {
        printHeader("Search appointments by customer last name.");
        return io.readRequiredString("Last Name: ");
    }
    
    
    // * * * * * * * * * * * USER FEEDBACK * * * * * * * * * * * * 
    
    public boolean confirm(String message) {
        return io.readBoolean(String.format("%s [y/n]:", message));
    }
    
    // * * * * Specific Menu Splashes * * * * 
    
    public void welcome() {
        String header = "Clinic Family Dentistry";
        io.print("\n" + "=".repeat((int)(header.length() * 1.4)));
        printHeader(header);
        io.print("=".repeat((int)(header.length() * 1.4))+ "\n");
    }
    
    public void appointmentMenuSplash() {
        printHeader("Appointment Options", true);
    }
    public void customerMenuSplash() {
        printHeader("Customer Options", true);
    }
    public void professionalMenuSplash() {
        printHeader("Professional Options", true);
    }
    public void userMenuSplash() {
        printHeader("User Options", true);
    }
    
    public void goodbye() {
        printHeader("Good Bye!");
    }

    // * * * * Non-specific splashes * * * * 
    
    public void displayErrors(Response r) {
        io.print("");
        printHeader("ERROR");
        for (String message : r.getErrors()) {
            io.print(message);
        }
        io.print("");
    }

    public void displaySuccess() {
        printHeader("Success.");
    }
    
    public void print(String message) {
        io.print(message);
    }

    public void backToMainMessage() {
        printHeader("Back to Main Menu");
    }
    
    public void clear(){
        io.cls();
    }
    
    public void clear2(){
        try {
            io.CLS();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // * * * * * * * * * * * PRIVATE FEEDBACK ENHANCERS * * * * * * * * * * * * 
    
    private void printHeader(String message) {
        printHeader(message, false);
    }
    
    private void printHeader(String message, boolean spacing) {
        String whiteSpace = (spacing) ? "\n" : "";
        io.print(String.format("%s%s%s%s%s", new Object[] {whiteSpace, LEFT_BANNER, message, RIGHT_BANNER, whiteSpace}));
    }
}
