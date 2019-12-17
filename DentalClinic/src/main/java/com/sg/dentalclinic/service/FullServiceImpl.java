package com.sg.dentalclinic.service;

import com.sg.dentalclinic.data.AppointmentDao;
import com.sg.dentalclinic.data.CustomerDao;
import com.sg.dentalclinic.data.ProfessionalDao;
import com.sg.dentalclinic.data.UserDao;
import com.sg.dentalclinic.models.Appointment;
import com.sg.dentalclinic.service.audit.AuditDaoImpl;

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

    
}
