package com.hjp.studentquizgrades.controller;

import com.hjp.studentquizgrades.ui.*;
import com.hjp.studentquizgrades.dao.*;

import java.util.List;

/**
 *
 * @author Henry Perrottet
 */
public class StudentQuizGradesController {
    StudentQuizGradesDao dao;
    StudentQuizGradesView view;
    
    public StudentQuizGradesController(StudentQuizGradesDao _dao, StudentQuizGradesView _view) {
        this.dao = _dao;
        this.view = _view;
    }
    
    public void run() {
        int select;
        boolean keepGoing = true;
        
        try {
            while(keepGoing) {
                select = getSelect();
                switch(select) {
                    case 1:
                        showStudents();
                        break;
                    case 2:
                        addStudent();
                        break;
                    case 3:
                        removeStudent();
                        break;
                    case 4:
                        showStudentGrades();
                        break;
                    case 5:
                        showAvgGrade();
                        break;
                    case 6:
                        displayExit();
                        keepGoing = false;
                        break;
                    default:
                        displayUnknownCommand();

                }
            }
        }
        catch(StudentQuizGradesDaoException e ) {
            view.displayError(e.getMessage() );
        }
    }
    public int getSelect() {
        return view.displayMenuAndGetSelect();
    }
    
    public void showStudents() throws StudentQuizGradesDaoException {
        view.displayListStudentBanner();
        view.showStudents( dao.getStudents() );
        view.displayContinue();
    }
    
    public void addStudent() throws StudentQuizGradesDaoException {
        view.displayAddStudentBanner();
        String name = view.readStudentName();
        List<Integer> grades = view.readGrades();
        String result = dao.addStudent(name, grades);
        if(result != null) {
            view.displayAlreadyExists();
        }
        view.displayContinue();
    }
    
    public void removeStudent() throws StudentQuizGradesDaoException{
        view.displayRemoveStudentBanner();
        String name = view.readStudentName();
        view.displayRemovalResult( dao.removeStudent(name) );
        view.displayContinue();
    }
    public void showStudentGrades() throws StudentQuizGradesDaoException {
        view.displayGetStudentGradesBanner();
        String name = view.readStudentName();
        List<Integer> grades = dao.getStudentGrades(name);
        view.showStudentGrades(grades);
        view.displayContinue();
    }
    public void showAvgGrade() throws StudentQuizGradesDaoException{
        view.displayGetAvgGradeBanner();
        String name = view.readStudentName();
        view.showAvgGrade( dao.getAvgGrade(name) );
        view.displayContinue();
    }
    public void displayExit() {
        view.displayExit();
    }
    public void displayUnknownCommand() {
        view.displayUnknownCommand();
    }
}
