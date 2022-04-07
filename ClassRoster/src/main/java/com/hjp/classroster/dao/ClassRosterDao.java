package com.hjp.classroster.dao;

import com.hjp.classroster.dto.*;
import java.util.List;

/**
 *
 * @author Henry
 */
public interface ClassRosterDao {
    
    List<Student> getAllStudents() throws ClassRosterPersistenceException;
    
    Student addStudent(String _id, Student _student) throws ClassRosterPersistenceException;
    
    Student getStudent(String _id) throws ClassRosterPersistenceException;
    
    Student removeStudent(String _id) throws ClassRosterPersistenceException;
}
