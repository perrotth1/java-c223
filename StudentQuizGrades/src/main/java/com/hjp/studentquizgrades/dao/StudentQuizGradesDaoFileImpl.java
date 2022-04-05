package com.hjp.studentquizgrades.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Henry Perrottet
 */
public class StudentQuizGradesDaoFileImpl implements StudentQuizGradesDao {
    private static final String GRADES_FILE = "grades.txt";
    private static final String DELIMITER = "::";
            
    Map<String, List<Integer>> grades = new HashMap<>();
    
    @Override
    public Set<String> getStudents() throws StudentQuizGradesDaoException{
        loadData();
        return grades.keySet();
    }

    @Override
    public String addStudent(String _student, List<Integer> _grades) throws StudentQuizGradesDaoException{
        loadData();
        if( grades.get(_student) == null ) {
            grades.put(_student, _grades);
            storeData();
            return null;
        }
        else {
            return _student;
        }
    }

    @Override
    public String removeStudent(String _student) throws StudentQuizGradesDaoException{
        loadData();
        List<Integer> previous = grades.remove(_student);
        storeData();
        if(previous == null) {
            return null;    //this means not found
        }
        else {
            return _student;    //this means successfully removed
        }
    }

    @Override
    public List<Integer> getStudentGrades(String _student) throws StudentQuizGradesDaoException{
        loadData();
        List<Integer> studentGrades = grades.get(_student);
        
        return studentGrades;   //will be null if not found 
    }

    @Override
    public int getAvgGrade(String _student) throws StudentQuizGradesDaoException{
        loadData();
        List<Integer> studentGrades = grades.get(_student);
        double sum = 0, count = 0;
        
        if(studentGrades == null) {
            return -1;
        }
        else {
            for(Integer grade : studentGrades) {
                sum += grade;
                count++;
            }
            return( (int)( sum/count ) );
        }
    }
    
    public String marshalStudent(String _student, List<Integer> _grades) {
        String lineRecord = _student;
        for(Integer grade : _grades) {
            lineRecord += DELIMITER + grade.toString();
        }
        return lineRecord;
    }
    public String[] unmarshalStudent(String _line) {
        String[] tokens = _line.split(DELIMITER);
        return tokens;
    }
    public void loadData() throws StudentQuizGradesDaoException{
        Scanner sc;
        try {
            sc = new Scanner( new BufferedReader( new FileReader(GRADES_FILE) ) );
        }
        catch(FileNotFoundException e) {
            throw new StudentQuizGradesDaoException("Error writing to file",e);
        }
        
        String line;
        String tokens[];
        List<Integer> studentGrades;
        while(sc.hasNextLine()) {
            studentGrades = new ArrayList<>();
            line = sc.nextLine();
            if(line.length() > 0) {
                tokens = unmarshalStudent(line);
                for(int i = 1; i < tokens.length; i++) {
                    studentGrades.add( Integer.parseInt(tokens[i]) );
                }
                grades.put(tokens[0], studentGrades);
            }
        }
    }
    public void storeData() throws StudentQuizGradesDaoException{
        PrintWriter out;
        
        try {
            out = new PrintWriter( new FileWriter(GRADES_FILE) );
        }
        catch(IOException e) {
            throw new StudentQuizGradesDaoException("Error writing to file",e);
        }
        
        String outLine;
        for(String s : grades.keySet() ) {
            outLine = marshalStudent( s, grades.get(s) );
            out.println(outLine);
            out.flush();
        }
        out.close();
    }
    
}
