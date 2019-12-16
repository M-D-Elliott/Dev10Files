package com.sg.dentalclinic.service;

import com.sg.dentalclinic.data.AppointmentDao;
import com.sg.dentalclinic.data.CustomerDao;
import com.sg.dentalclinic.service.audit.AuditDaoImpl;

public class CustomerServiceImpl 
        extends Service
        implements CustomerService {

    private AppointmentDao appointmentDao;
    private CustomerDao customerDao;

    public CustomerServiceImpl(AppointmentDao appointmentDao, CustomerDao customerDao, AuditDaoImpl auditDao) {
        super(auditDao);
        this.appointmentDao = appointmentDao;
        this.customerDao = customerDao;
    }

    @Override
    public boolean getCustomer(int ID) {
        return true;
    }


    
}
