package com.hjp.classroster.dao;

/**
 *
 * @author Henry
 */
public interface ClassRosterAuditDao {
    public void writeAuditEntry(String _entry) throws ClassRosterPersistenceException;
}
