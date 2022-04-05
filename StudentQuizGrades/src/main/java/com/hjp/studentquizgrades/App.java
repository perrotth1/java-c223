package com.hjp.studentquizgrades;

import com.hjp.studentquizgrades.ui.*;
import com.hjp.studentquizgrades.dao.*;
import com.hjp.studentquizgrades.controller.*;

/**
 *
 * @author Henry Perrottet
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        StudentQuizGradesView view = new StudentQuizGradesView(io);
        StudentQuizGradesDao dao = new StudentQuizGradesDaoFileImpl();
        StudentQuizGradesController controller = new StudentQuizGradesController(dao, view);
        
        controller.run();
    }
}
