package com.sg.dentalclinic.ui;

import com.sg.dentalclinic.models.Customer;
import com.sg.dentalclinic.models.Professional;
import com.sg.dentalclinic.models.Specialty;
import com.sg.dentalclinic.service.Response;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View {
    // IO class, for composition
    private UserIO io;
    
    // banner for encasing certain titles
    // specifically for clinic family dentistry (kinda! ;o).
    private static final String LEFT_BANNER = " ===";
    private static final String RIGHT_BANNER = "=== ";
    
    private static final String LEFT_SUB_BANNER = " --";
    private static final String RIGHT_SUB_BANNER = "-- ";
    
    private final int STANDARD_TAKE;

    public View(UserIO io) {
        this(io, 25);
    }
    public View(UserIO io, int standardTake) {
        this.io = io;
        this.STANDARD_TAKE = standardTake;
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
    
    LocalDate readDate() {
        String prompt = "Please enter a date in YYYY-MM-DD format.";
        return io.readRequiredDate(prompt, DateTimeFormatter.BASIC_ISO_DATE);
       
    }
    
    Professional listAndReadProfessional(List<Professional> professionals){
        String prompt = "Select a dental professional";
        return listAndReadDBObject(prompt, professionals);
    }
    
    Customer listAndReadCustomer(List<Customer> customers){
        String prompt = "Select a dental customer";
        return listAndReadDBObject(prompt, customers);
    }
    
    Customer createNewCustomer() {
        return new Customer();
    }
    
    
    private <T> T listAndReadDBObject(String prompt, List<T> objects) {
        int selectedIndex = 0;
        int listingIndex = 0;
        
        boolean continueLooping = true;
        
        while(continueLooping){
            displayObjects(objects, STANDARD_TAKE, listingIndex);
            String selection = io.readRequiredString("\n" + prompt + " (q for quit, m for more, b for back)");
            
            if(selection.equalsIgnoreCase("more") || selection.equalsIgnoreCase("m")){
                if(objects.size() > STANDARD_TAKE * (listingIndex + 1)){
                    listingIndex++;
                } else {
                    io.print("No more results.\n");
                }
            }else if(selection.equalsIgnoreCase("back") || selection.equalsIgnoreCase("b")){
                if(listingIndex > 0){
                    listingIndex--;
                } else {
                    io.print("On first page.\n");
                }
            } else if(selection.equals("q") || selection.equals("quit")) {
                continueLooping = false;
            } else {
                selectedIndex = io.tryParseInt(selection);
                if(selectedIndex == 0 || selectedIndex > objects.size()){
                    io.print("Response invalid.");
                } else {
                    continueLooping = false;
                }
            }
        }
        return objects.get(selectedIndex - 1);
    }
    
    public boolean shouldCreateCustomer(String header) {
        printHeader(header);
        io.print("1. Create a new customer.");
        io.print("2. Search for an existing customer.");
        return io.readInt("Select [1-2]: ", 1, 2) == 1;
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
    
    public <T> void displayObjects(List<T> objects){
        displayObjects(objects, objects.size(), 0);
    }
    
    public <T> void displayObjects(List<T> objects, int take, int i) {
        if(objects.isEmpty()){
            print("No results.");
        }
        objects.stream()
                .skip(take * i)
                .limit(take)
                .forEach(o -> {
                    io.print(objects.indexOf(o) + 1 + ". " + o);
                });
    }
    
    // * * * * Specific SubHeaders * * * * 
    
    void searchAppointmentsByDayAndProfessionalBanner() {
         printSubHeader("Search by day and Professional");
    }
    
    void searchAppointmentsByDayAndCustomerBanner() {
        printSubHeader("Search by day and Customer");
    }
    
    void addNewCustomerBanner() {
        printSubHeader("Add a new Customer");
    }

    void scheduleNewAppointmentBanner() {
        printSubHeader("Schedule a NEW Appointment");
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
    
    private void printSubHeader(String message) {
        printSubHeader(message, true);
    }
    
    private void printSubHeader(String message, boolean spacing) {
        printHeader(message, spacing, LEFT_SUB_BANNER, RIGHT_SUB_BANNER);
    }
    
    private void printHeader(String message) {
        printHeader(message, true);
    }
    
    private void printHeader(String message, boolean spacing) {
        printHeader(message, spacing, LEFT_BANNER, RIGHT_BANNER);
    }
    
    private void printHeader(String message, boolean spacing, String leftBanner, String rightBanner) {
        String whiteSpace = (spacing) ? "\n" : "";
        io.print(String.format("%s%s%s%s%s", new Object[] {whiteSpace, leftBanner, message, rightBanner, whiteSpace}));
    }
}
