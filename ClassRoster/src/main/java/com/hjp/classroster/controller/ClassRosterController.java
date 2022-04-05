package com.hjp.classroster.controller;

import com.hjp.classroster.ui.*;
import com.hjp.classroster.dao.*;
import com.hjp.classroster.dto.*;
/**
 *
 * @author Henry
 */
public class ClassRosterController {
    ClassRosterView view;
    ClassRosterDao dao;
    
    public ClassRosterController(ClassRosterView _view, ClassRosterDao _dao){
        this.view = _view;
        this.dao = _dao;
    }
    
    public void run(){
        boolean keepGoing = true;
        int selection;
        
        try{
            while(keepGoing){
                selection = printMenuGetSelection();

                switch(selection){
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        addStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 0:
                        view.printGoodbye();
                        keepGoing = false;
                        break;
                    default:
                        view.printUnknownCommand();
                        break;
                }
            }
        }
        catch(ClassRosterDaoException e){
            view.printError(e.getMessage());
        }
        
        
    }
    
    public int printMenuGetSelection(){
        view.printMenu();
        return( view.getSelection() );
    }
    
    public void addStudent() throws ClassRosterDaoException{
        view.printAddStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.printSuccess();
        view.pressEnterContinue();
    }
    public void listStudents() throws ClassRosterDaoException{
        view.printListStudentsBanner();
        view.printAllStudents( dao.getAllStudents() );
        view.pressEnterContinue();
    }
    public void viewStudent() throws ClassRosterDaoException{
        view.printViewStudentBanner();
        String id = view.readStudentId();
        view.printStudentInfo( dao.getStudent(id) );
        view.pressEnterContinue();
    }
    public void removeStudent() throws ClassRosterDaoException{
        view.printRemoveStudentBanner();
        String id = view.readStudentId();
        
        boolean check = view.askConfirmation();
        if(check){
            view.printRemovalResult( dao.removeStudent(id) );
        }
        
        view.pressEnterContinue();
    }
}
