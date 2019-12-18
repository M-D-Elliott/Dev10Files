package com.sg.dentalclinic.ui;

import com.sg.dentalclinic.models.Appointment;
import com.sg.dentalclinic.models.Customer;
import com.sg.dentalclinic.models.Professional;
import com.sg.dentalclinic.models.Specialty;
import com.sg.dentalclinic.service.FullService;
import java.time.LocalDate;
import java.util.List;

public class Controller {

    // * * * * * * * * * * * INITIALIZATION * * * * * * * * * * * * 
    
    private FullService service;
    
    private View view;

    public Controller() {
    }
    
    public Controller(FullService service, View view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() {
        mainMenuLoop();
    }
    
    // * * * * * * * * * * * MENU LOOPS * * * * * * * * * * * * 
    private void mainMenuLoop() {
        MainMenuOption selection;

        do {
            view.clear();
            view.welcome();
            selection = view.selectFromMainMenu();
            switch (selection) {
                case APPOINTMENT_MENU:
                    appointmentMenuLoop();
                    break;
                case CUSTOMER_MENU:
                    customerMenuLoop();
                    break;
                case PROFESSIONAL_MENU:
                    professionalMenuLoop();
                    break;
                case USER_MENU:
                    userMenuLoop();
                    break;
            }
        } while (selection != MainMenuOption.EXIT);

        view.goodbye();
    }

    private void appointmentMenuLoop() {
        AppointmentMenuOption selection;

        do {
            view.clear();
            view.appointmentMenuSplash();
            selection = view.selectFromAppointmentMenu();
            switch (selection) {
                case RETURN:
                    break;
                case SEARCH_BY_DAY_AND_DENTIST:
                    searchAppointmentsByDayAndProfessional();
                    break;
                case SEARCH_BY_DAY_AND_CUSTOMER:
                    searchAppointmentsByDayAndCustomer();
                    break;
                case UPDATE_APPOINTMENT:
                    updateAppointment();
                    break;
                case CANCEL_APPOINTMENT:
                    cancelAppointment();
                    break;
            }
        } while (selection != AppointmentMenuOption.RETURN);
        view.backToMainMessage();
    }
    private void customerMenuLoop() {
        CustomerMenuOption selection;

        do {
            view.clear();
            view.customerMenuSplash();
            selection = view.selectFromCustomerMenu();
            switch (selection) {
                case RETURN:
                    break;
                case ADD_CUSTOMER:
                    addCustomer();
                    break;
                case SCHEDULE_APPOINTMENT:
                    scheduleAppointment();
                    break;
            }
        } while (selection != CustomerMenuOption.RETURN);
        view.backToMainMessage();
    }
    
    private void professionalMenuLoop() {
        ProfessionalMenuOption selection;

        do {
            view.clear();
            view.professionalMenuSplash();
            selection = view.selectFromProfessionalMenu();
            switch (selection) {
                case RETURN:
                    break;
                case ADD_PROFESSIONAL:
                    addProfessional();
                    break;
                case VIEW_APPOINTMENTS:
                    viewProfessionalsAppointments();
                    break;
            }
        } while (selection != ProfessionalMenuOption.RETURN);
        view.backToMainMessage();
    }
    
    private void userMenuLoop() {
        UserMenuOption selection;

        do {
            view.clear();
            view.userMenuSplash();
            selection = view.selectFromUserMenu();
            switch (selection) {
                case RETURN:
                    break;
                case LOG_OUT:
                    logOut();
                    break;
            }
        } while (selection != UserMenuOption.RETURN);
        view.backToMainMessage();
    }

    // * * * * * * * * * * * SERVICE FUNCTIONS * * * * * * * * * * * * 
    
    private void searchAppointmentsByDayAndProfessional() {
        view.searchAppointmentsByDayAndProfessionalBanner();
        LocalDate date = view.readDate();
        
        if(date != null) {
            List<Professional> professionals = service.getAllProfessionals();
        
            Professional professional = view.listAndReadProfessional(professionals); 
            List<Appointment> appointments = service.searchAppointments(date, professional);
            view.displayObjects(appointments);
        }

    }

    private void searchAppointmentsByDayAndCustomer() {
        view.searchAppointmentsByDayAndCustomerBanner();
        LocalDate date = view.readDate();
        
        if(date != null){
            List<Customer> customers = service.getAllCustomers();
        
            Customer customer = view.listAndReadCustomer(customers);
            List<Appointment> appointments = service.searchAppointments(date, customer);
            view.displayObjects(appointments);
        }
    }
    
    private void addCustomer() {
        view.addNewCustomerBanner();
        Customer customer = view.createNewCustomer();
        
        service.addCustomer(customer);
    }
    
    private void scheduleAppointment() {
//        view.scheduleNewAppointmentBanner();
//        Customer customer = view.getOrAddCustomer();
//        LocalDate date = view.readDate();
//        Specialty specialty = view.readSpecialty();
//        List<Professional> professionalsAvailable = service.searchAppointments(date, customer, specialty);
    }

    private void updateAppointment() {
//        view.updateAppointmentBanner();
        
    }

    private void cancelAppointment() {
        view.print("cancel apt");
    }

    private void viewProfessionalsAppointments() {
        view.print("professional's appts");
    }
    
    private void addProfessional() {
        view.print("add professional");
    }

    private void logOut() {
        view.print("Logging out...");
    }
}
