package com.hjp.classroster.dao;

import com.hjp.classroster.dto.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;

/**
 *
 * @author Henry
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {
    private Map<String, Student> students = new HashMap<>();
    private final String DELIMITER = "::";
    private final String DATA_FILE = "data.txt";
    
    @Override
    public List<Student> getAllStudents() throws ClassRosterDaoException{
        loadRoster();
        return new ArrayList<>(students.values());
    }

    @Override
    public Student addStudent(String _id, Student _student) throws ClassRosterDaoException{
        loadRoster();
        Student prevStudent = students.put(_id, _student);
        storeRoster();
        return prevStudent;
    }

    @Override
    public Student getStudent(String _id) throws ClassRosterDaoException{
        loadRoster();
        return students.get(_id);
    }

    @Override
    public Student removeStudent(String _id) throws ClassRosterDaoException{
        loadRoster();
        Student existingStudent = students.remove(_id);
        storeRoster();
        return existingStudent;
    }
    
    public Student unmarshalStudent(String _line){
        String[] tokens = _line.split(DELIMITER);
        Student student = new Student(tokens[0]);
        student.setFirstName(tokens[1]);
        student.setLastName(tokens[2]);
        student.setCohort(tokens[3]);
        
        return student;
    }
    public String marshalStudent(Student _student){
        String line = _student.getStudentId() + DELIMITER +
                      _student.getFirstName() + DELIMITER +
                      _student.getLastName() + DELIMITER +
                      _student.getCohort();
        return line;
    }
    
    public void loadRoster() throws ClassRosterDaoException{
        Scanner in;
        try{
            in = new Scanner( new BufferedReader( new FileReader(DATA_FILE) ) );
        }
        catch(java.io.FileNotFoundException e){
            throw new ClassRosterDaoException("Could not load from file!", e);
        }
        
        String buffer;
        Student currentStudent;
        while(in.hasNextLine()){
            buffer = in.nextLine();
            if(buffer.length() > 0){
                currentStudent = unmarshalStudent( buffer );
                students.put(currentStudent.getStudentId(), currentStudent);
            }
        }
        in.close();
    }
    
    public void storeRoster() throws ClassRosterDaoException {
        PrintWriter out;
        
        try{
            out = new PrintWriter( new FileWriter(DATA_FILE) );
        }
        catch(java.io.IOException e){
            throw new ClassRosterDaoException("Could not store to file!", e);
        }
        
        List<Student> studentList = this.getAllStudents();
        for(Student s : studentList){
            out.println( marshalStudent(s) );
            out.flush();
        }
        out.close();
    }
}
