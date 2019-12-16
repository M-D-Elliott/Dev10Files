package com.sg.dentalclinic.ui;

import com.sg.dentalclinic.service.AppointmentService;
import com.sg.dentalclinic.service.CustomerService;
import com.sg.dentalclinic.service.ProfessionalService;
import com.sg.dentalclinic.service.UserService;

public class Controller {

    private UserService userService;
    private CustomerService customerService;
    private ProfessionalService professionalService;
    private AppointmentService appointmentService;

    public Controller(UserService userService, CustomerService customerService, ProfessionalService professionalService, AppointmentService appointmentService) {
        this.userService = userService;
        this.customerService = customerService;
        this.professionalService = professionalService;
        this.appointmentService = appointmentService;
    }
    
    public void run() {
    }

}
