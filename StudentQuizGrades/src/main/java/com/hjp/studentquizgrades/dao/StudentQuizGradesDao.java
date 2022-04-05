package com.hjp.studentquizgrades.dao;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Henry Perrottet
 */
public interface StudentQuizGradesDao {
    Set<String> getStudents() throws StudentQuizGradesDaoException;
    
    String addStudent(String _student, List<Integer> _grades) throws StudentQuizGradesDaoException;
    
    String removeStudent(String _student) throws StudentQuizGradesDaoException;
    
    List<Integer> getStudentGrades(String _student) throws StudentQuizGradesDaoException;
    
    int getAvgGrade(String _student) throws StudentQuizGradesDaoException;
}
