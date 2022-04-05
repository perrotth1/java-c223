package com.hjp.classroster.dao;

/**
 *
 * @author Henry
 */
public class ClassRosterDaoException extends Exception {
    public ClassRosterDaoException(String _message){
        super(_message);
    }
    public ClassRosterDaoException(String _message, Throwable _e){
        super(_message, _e);
    }
}
