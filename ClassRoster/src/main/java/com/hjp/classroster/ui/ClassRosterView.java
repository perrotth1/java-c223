package com.hjp.classroster.ui;

import com.hjp.classroster.dto.*;
import java.util.List;
/**
 *
 * @author Henry
 */
public class ClassRosterView {
    UserIO io;
    
    public ClassRosterView(UserIO _io){
        this.io = _io;
    }
    
    public void printMenu(){
        io.print("=== CLASS ROSTER MENU ===");
        io.print(" 1) List All Students");
        io.print(" 2) Create New Student ");
        io.print(" 3) View a Student ");
        io.print(" 4) Remove a Student");
        io.print(" 0) Exit");
        
    }
    
    public int getSelection(){
        return( io.readInt("Choose Option...") );
    }
    public Student getNewStudentInfo(){
        String id = io.readString("[*] Please enter student ID: ");
        String firstName = io.readString("[*] Please enter student first name: ");
        String lastName = io.readString("[*] Please enter student last name: ");
        String cohort = io.readString("[*] Please enter student cohort: ");
        Student newStudent = new Student(id);
        newStudent.setFirstName(firstName);
        newStudent.setLastName(lastName);
        newStudent.setCohort(cohort);
        return newStudent;
    }
    
    public void printStudentInfo(Student _student){
        if(_student != null){
            io.print( String.format(" #%s : %s %s : %s", _student.getStudentId(), 
                                                 _student.getFirstName(),
                                                 _student.getLastName(),
                                                 _student.getCohort()
                                   ) 
                    );
        }
        else{
            printStudentNotFound();
        }
    }
    
    public void printAllStudents(List<Student> _students){
        for(Student s : _students){
            printStudentInfo(s);
        }
    }
    
    public String readStudentId(){
        return io.readString("Enter Student ID: "); 
    }
    
    public boolean askConfirmation(){
        String choice = io.readString("[*] Are you sure? (y/n)");
        if(choice.equalsIgnoreCase("y")){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void printGoodbye(){
        io.print("[*] Exiting. Goodbye!");
    }
    public void printUnknownCommand(){
        io.print("[!] Unknown command! ");
    }
    public void pressEnterContinue(){
        io.readString("[*] Press enter to continue...");
    }
    public void printRemovalResult(Student _student){
        if(_student != null){
            printSuccess();
        }
        else{
            printStudentNotFound();
        }
    }
    public void printSuccess(){
        io.print("[*] Operation successful!");
    }
    public void printStudentNotFound(){
        io.print("[!] Student not found! ");
    }
    
    public void printAddStudentBanner(){
        io.print("=== ADD NEW STUDENT ===");
    }
    public void printListStudentsBanner(){
        io.print("=== LIST ALL STUDENTS ===");
    }
    public void printViewStudentBanner(){
        io.print("=== VIEW A STUDENT ===");
    }
    public void printRemoveStudentBanner(){
        io.print("=== REMOVE STUDENT ===");
    }
    public void printError(String _message){
        io.print("[!] Error: " + _message);
    }
}
