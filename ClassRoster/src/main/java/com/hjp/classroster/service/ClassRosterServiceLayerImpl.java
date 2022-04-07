package com.hjp.classroster.service;

import com.hjp.classroster.dao.*;
import com.hjp.classroster.dto.*;
import java.util.List;

/**
 *
 * @author Henry
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {
    private final ClassRosterDao dao;
    
    public ClassRosterServiceLayerImpl(ClassRosterDao _dao){
        this.dao = _dao;
    }

    @Override
    public void createStudent(Student _student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {
        // First check to see if there is alreay a student 
        // associated with the given student's id
        // If so, we're all done here - 
        // throw a ClassRosterDuplicateIdException
        if (dao.getStudent(_student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException(
                    "ERROR: Could not create student.  Student Id "
                    + _student.getStudentId()
                    + " already exists");
        }

        // Now validate all the fields on the given Student object.  
        // This method will throw an
        // exception if any of the validation rules are violated.
        validateStudentData(_student);

        // We passed all our business rules checks so go ahead 
        // and persist the Student object
        dao.addStudent(_student.getStudentId(), _student);
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String _studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(_studentId);
    }

    @Override
    public Student removeStudent(String _studentId) throws ClassRosterPersistenceException {
        return dao.removeStudent(_studentId);
    }
    
    //IMPLEMENTATION-PRIVATE METHODS
    
    private void validateStudentData(Student student) throws ClassRosterDataValidationException {
        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {

            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }
    
}
