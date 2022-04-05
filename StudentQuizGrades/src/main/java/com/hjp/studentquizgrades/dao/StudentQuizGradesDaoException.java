package com.hjp.studentquizgrades.dao;

/**
 *
 * @author Henry Perrottet
 */
public class StudentQuizGradesDaoException extends Exception {
    public StudentQuizGradesDaoException(String message) {
        super(message);
    }
    public StudentQuizGradesDaoException(String message, Throwable e) {
        super(message, e);
    }
}
