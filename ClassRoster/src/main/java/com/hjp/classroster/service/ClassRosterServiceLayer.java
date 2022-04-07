package com.hjp.classroster.service;

import com.hjp.classroster.dto.*;
import com.hjp.classroster.dao.*;
import java.util.List;
/**
 *
 * @author Henry
 */
public interface ClassRosterServiceLayer {
    void createStudent(Student _student) throws
           ClassRosterDuplicateIdException,
           ClassRosterDataValidationException,
           ClassRosterPersistenceException;
    
    List<Student> getAllStudents() throws ClassRosterPersistenceException;
    
    Student getStudent(String _studentId) throws ClassRosterPersistenceException;
    
    Student removeStudent(String _studentId) throws ClassRosterPersistenceException;
}
