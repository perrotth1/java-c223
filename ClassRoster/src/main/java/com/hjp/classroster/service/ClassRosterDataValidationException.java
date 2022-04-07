package com.hjp.classroster.service;

/**
 *
 * @author Henry
 */
public class ClassRosterDataValidationException extends Exception{
    public ClassRosterDataValidationException(String _message){
        super(_message);
    }
    public ClassRosterDataValidationException(String _message, Throwable _e){
        super(_message, _e);
    }
}
