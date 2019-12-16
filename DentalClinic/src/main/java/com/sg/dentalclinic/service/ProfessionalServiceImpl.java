package com.sg.dentalclinic.service;

import com.sg.dentalclinic.data.ProfessionalDao;
import com.sg.dentalclinic.service.audit.AuditDaoImpl;

public class ProfessionalServiceImpl 
        extends Service
        implements CustomerService {
    
    private ProfessionalDao professionalDao;

    public ProfessionalServiceImpl(ProfessionalDao professionalDao, AuditDaoImpl auditDao) {
        super(auditDao);
        this.professionalDao = professionalDao;
    }

    @Override
    public boolean getCustomer(int ID) {
        return true;
    }


}
