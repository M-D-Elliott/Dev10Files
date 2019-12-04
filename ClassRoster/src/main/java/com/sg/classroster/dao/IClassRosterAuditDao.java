package com.sg.classroster.dao;

public interface IClassRosterAuditDao {
    
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
    
}
