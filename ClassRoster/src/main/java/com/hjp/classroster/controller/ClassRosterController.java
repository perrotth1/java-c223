package com.hjp.classroster.controller;

import com.hjp.classroster.ui.*;
import com.hjp.classroster.dto.*;
import com.hjp.classroster.service.*;
import com.hjp.classroster.dao.*;
/**
 *
 * @author Henry
 */
public class ClassRosterController {
    ClassRosterView view;
    ClassRosterServiceLayer service;
    
    public ClassRosterController(ClassRosterView _view, ClassRosterServiceLayer _service){
        this.view = _view;
        this.service = _service;
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
        catch(ClassRosterPersistenceException e){
            view.printError(e.getMessage());
        }
        
        
    }
    
    public int printMenuGetSelection(){
        view.printMenu();
        return( view.getSelection() );
    }
    
    public void addStudent() throws ClassRosterPersistenceException{
        view.printAddStudentBanner();
        boolean hasErrors = false;
        do {
            Student currentStudent = view.getNewStudentInfo();
            try {
                service.createStudent(currentStudent);
                view.printSuccess();
                hasErrors = false;
            } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e) {
                hasErrors = true;
                view.printError(e.getMessage());
            }
        } while (hasErrors);
        view.pressEnterContinue();
    }
    
    public void listStudents() throws ClassRosterPersistenceException{
        view.printListStudentsBanner();
        view.printAllStudents( service.getAllStudents() );
        view.pressEnterContinue();
    }
    public void viewStudent() throws ClassRosterPersistenceException{
        view.printViewStudentBanner();
        String id = view.readStudentId();
        view.printStudentInfo( service.getStudent(id) );
        view.pressEnterContinue();
    }
    
    public void removeStudent() throws ClassRosterPersistenceException{
        view.printRemoveStudentBanner();
        String id = view.readStudentId();
        
        service.removeStudent(id);
        
        view.printSuccess();
        
        view.pressEnterContinue();
    }
}
