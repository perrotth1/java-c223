package com.hjp.classroster;

import com.hjp.classroster.ui.*;
import com.hjp.classroster.dao.*;
import com.hjp.classroster.controller.*;

/**
 *
 * @author Henry
 */
public class App {
    public static void main(String[] args){
        UserIO io = new UserIOConsoleImpl();
        ClassRosterView view = new ClassRosterView(io);
        ClassRosterDao dao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(view, dao);
        controller.run();
    }
}
