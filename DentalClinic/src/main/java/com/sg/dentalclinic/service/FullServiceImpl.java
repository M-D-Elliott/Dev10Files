package com.sg.dentalclinic.service;

import com.sg.dentalclinic.data.AppointmentDao;
import com.sg.dentalclinic.data.CustomerDao;
import com.sg.dentalclinic.data.ProfessionalDao;
import com.sg.dentalclinic.data.UserDao;
import com.sg.dentalclinic.models.Appointment;
import com.sg.dentalclinic.models.Customer;
import com.sg.dentalclinic.models.Professional;
import com.sg.dentalclinic.models.Specialty;
import com.sg.dentalclinic.service.audit.AuditDaoImpl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FullServiceImpl
        extends Service
        implements FullService {

    private AppointmentDao appointmentDao;
    private ProfessionalDao professionalDao;
    private CustomerDao customerDao;
    private UserDao userDao;

    public FullServiceImpl(AppointmentDao appointmentDao, ProfessionalDao professionalDao, CustomerDao customerDao, UserDao userDao, AuditDaoImpl auditDao) {
        super(auditDao);
        this.appointmentDao = appointmentDao;
        this.professionalDao = professionalDao;
        this.customerDao = customerDao;
        this.userDao = userDao;
    }

    @Override
    public boolean makeAppointment(Appointment appoitment) {
        return true;
    }

    @Override
    public List<Appointment> searchAppointments(LocalDate date, Professional professional) {
        appointmentDao.setDate(date.toString());
        
        List<Appointment> allApts = appointmentDao.findAll();
        
        List<Customer> customers = getAllCustomers();
        
        allApts = allApts.stream()
                .filter(a -> a.getProfessionalLastName().equals(professional.getLastName()) && a.getProfessionalSpecialty() == professional.getSpecialty())
                .collect(Collectors.toList());
        
        allApts.stream()
                .forEach(a -> a.setProfessional(professional));
        
        allApts.stream()
                .forEach(a -> {
                    Customer customer = customers.stream()
                            .filter(c -> c.getID() == a.getCustomerID())
                            .findFirst()
                            .orElse(null);
                    a.setCustomer(customer);
                });
        return allApts;
    }

    @Override
    public List<Appointment> searchAppointments(LocalDate date, Customer customer) {
                appointmentDao.setDate(date.toString());
        
        List<Appointment> allApts = appointmentDao.findAll();
        
        List<Professional> professionals = getAllProfessionals();
        
        allApts = allApts.stream()
                .filter(a -> a.getCustomerID() == customer.getID())
                .collect(Collectors.toList());
        
        allApts.stream()
                .forEach(a -> a.setCustomer(customer));
        
        allApts.stream()
                .forEach(a -> {
                    Professional professional = professionals.stream()
                            .filter(p -> a.getProfessionalLastName().equals(p.getLastName()) && a.getProfessionalSpecialty() == p.getSpecialty())
                            .findFirst()
                            .orElse(null);
                    a.setProfessional(professional);
                });
        return allApts;
    }
    
    @Override
    public void addCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Professional> getAllProfessionals() {
        return professionalDao.findAll();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }
}
