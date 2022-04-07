package com.hjp.classroster.dao;

/**
 *
 * @author Henry
 */
public class ClassRosterPersistenceException extends Exception {
    public ClassRosterPersistenceException(String _message){
        super(_message);
    }
    public ClassRosterPersistenceException(String _message, Throwable _e){
        super(_message, _e);
    }
}
