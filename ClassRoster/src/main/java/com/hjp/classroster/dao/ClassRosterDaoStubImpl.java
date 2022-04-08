package com.hjp.classroster.dao;

import com.hjp.classroster.dto.Student;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Henry
 */
public class ClassRosterDaoStubImpl implements ClassRosterDao {
    private Student student;
    
    public ClassRosterDaoStubImpl(){
        this.student = new Student("5");
        this.student.setFirstName("Gary");
        this.student.setLastName("Tester");
        this.student.setCohort("Testing Class");
    }
    
    public ClassRosterDaoStubImpl(Student _student){
        this.student= _student;
    }
    
    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        List<Student> list = new ArrayList<>();
        list.add(this.student);
        return list;
    }

    @Override
    public Student addStudent(String _id, Student _student) throws ClassRosterPersistenceException {
        if(_id.equals(this.student.getStudentId())){
            return this.student;
        }
        else{
            return null;
        }
    }

    @Override
    public Student getStudent(String _id) throws ClassRosterPersistenceException {
        if(_id.equals(this.student.getStudentId())){
            return this.student;
        }
        else{
            return null;
        }
    }

    @Override
    public Student removeStudent(String _id) throws ClassRosterPersistenceException {
        if(_id.equals(this.student.getStudentId())){
            return this.student;
        }
        else{
            return null;
        }
    }
    
}
