package com.hjp.classroster.dao;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
/**
 *
 * @author Henry
 */
public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao{
    private static final String AUDIT_FILE = "audit.txt";
    
    @Override
    public void writeAuditEntry(String _entry) throws ClassRosterPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (java.io.IOException e) {
            throw new ClassRosterPersistenceException("Could not persist audit information.", e);
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + _entry);
        out.flush();
    }
    
}
