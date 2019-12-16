package com.sg.dentalclinic;

import com.sg.dentalclinic.ui.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static final String CUSTOMER_FILE_PATH = "customers.txt";
    public static final String PROFESSIONAL_FILE_PATH = "professionals.txt";
    public static final String APPOINTMENT_FILE_PATH_STUB = "appointments_.txt";
    
    public static void main(String[] args) {

            ApplicationContext ctx = 
               new ClassPathXmlApplicationContext("context.xml");
            Controller controller = 
               ctx.getBean("controller", Controller.class);
            controller.run();
    }
}
