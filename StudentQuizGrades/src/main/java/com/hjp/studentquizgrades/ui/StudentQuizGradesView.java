package com.hjp.studentquizgrades.ui;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Henry Perrottet
 */
public class StudentQuizGradesView {
    UserIO io;
    
    public StudentQuizGradesView(UserIO _io) {
        this.io = _io;
    }
    
    public int displayMenuAndGetSelect() {
        io.print(" == Main Menu == \n 1) List Students\n 2) Add a Student\n 3) Remove a Student\n 4) Get Quiz Grades\n 5) Get Average Quiz Grade\n 6) Exit");
        return io.readInt("Please Enter an Option: ");
    }
    
    public void showStudents(Set<String> _students) {
        for(String s : _students) {
            io.print(s);
        }
    }
    
    public String readStudentName() {
        return io.readString("Please Enter Student Name: ");
    }
    
    public List<Integer> readGrades() {
        io.print("Please Enter Grades in Range 0-100, One at a Time (enter q to finish): ");
        int grade, count = 0;
        List<Integer> grades = new ArrayList<>();
        while(true) {
            count++;
            grade = io.readInt("Enter Grade " + count, 0, 100);
            if(grade != -1) {
                grades.add(grade);
            }
            else {
                break;
            }
        }
        return grades;
    }
    
    public void displayRemovalResult(String _student) {
        if(_student == null) {
            io.print("Student Not Found!");
        }
        else {
            io.print("Student Successfully Removed");
        }
    }
    
    public void showStudentGrades(List<Integer> _grades) {
        if(_grades == null) {
            io.print("Student Not Found!");
        }
        else {
            for( Integer grade : _grades ) {
                io.print(grade.toString());
            }
        }
    }
    public void showAvgGrade(int _avg) {
        io.print("Average Grade: " + _avg);
    }
    
    public void displayListStudentBanner() {
        io.print(" == Showing Students ==");
    }
    
    public void displayAddStudentBanner() {
        io.print(" == Add New Student == ");
    }
    
    public void displayRemoveStudentBanner() {
        io.print(" == Remove a Student == ");
    }
    
    public void displayGetStudentGradesBanner() {
        io.print(" == View Student Grades == ");
    }
    public void displayGetAvgGradeBanner() {
        io.print(" == View Average Grade == ");
    }
    
    public void displayContinue() {
        io.readString("Hit Enter to Continue...");
    }
    public void displayExit() {
        io.print("Exiting. Goodbye! ");
    }
    public void displayUnknownCommand() {
        io.print("Unknown Command!");
    }
    public void displayAlreadyExists() {
        io.print("Student Already Exists! ");
    }
    public void displayError(String e) {
        io.print(e);
    }
}
