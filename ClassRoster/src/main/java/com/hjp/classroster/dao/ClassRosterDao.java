package com.hjp.classroster.dao;

import com.hjp.classroster.dto.*;
import java.util.List;

/**
 *
 * @author Henry
 */
public interface ClassRosterDao {
    
    List<Student> getAllStudents() throws ClassRosterDaoException;
    
    Student addStudent(String _id, Student _student) throws ClassRosterDaoException;
    
    Student getStudent(String _id) throws ClassRosterDaoException;
    
    Student removeStudent(String _id) throws ClassRosterDaoException;
}
