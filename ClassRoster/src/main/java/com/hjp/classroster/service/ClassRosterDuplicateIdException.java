package com.hjp.classroster.service;

/**
 *
 * @author Henry
 */
public class ClassRosterDuplicateIdException extends Exception{
    public ClassRosterDuplicateIdException(String _message){
        super(_message);
    }
    public ClassRosterDuplicateIdException(String _message, Throwable _e){
        super(_message, _e);
    }
}
