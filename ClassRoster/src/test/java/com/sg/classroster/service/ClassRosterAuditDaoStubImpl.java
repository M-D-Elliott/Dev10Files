package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dao.IClassRosterAuditDao;

public class ClassRosterAuditDaoStubImpl implements IClassRosterAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        //do nothing . . .
    }
}
