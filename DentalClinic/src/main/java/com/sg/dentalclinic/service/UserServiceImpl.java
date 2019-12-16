package com.sg.dentalclinic.service;

import com.sg.dentalclinic.data.UserDao;
import com.sg.dentalclinic.service.audit.AuditDaoImpl;

public class UserServiceImpl 
        extends Service
        implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao, AuditDaoImpl auditDao) {
        super(auditDao);
        this.userDao = userDao;
    }

    @Override
    public boolean getUser(int ID) {
        return true;
    }
}
