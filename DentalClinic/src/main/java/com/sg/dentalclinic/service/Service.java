package com.sg.dentalclinic.service;

import com.sg.dentalclinic.service.audit.AuditDaoImpl;

public class Service {

    protected AuditDaoImpl auditDao;

    public Service(AuditDaoImpl auditDao) {
        this.auditDao = auditDao;
    }
    
}
