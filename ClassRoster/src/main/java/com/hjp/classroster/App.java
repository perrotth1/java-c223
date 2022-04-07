package com.hjp.classroster;

import com.hjp.classroster.ui.*;
import com.hjp.classroster.dao.*;
import com.hjp.classroster.controller.*;
import com.hjp.classroster.service.*;
/**
 *
 * @author Henry
 */
public class App {
    public static void main(String[] args){
        UserIO io = new UserIOConsoleImpl();
        ClassRosterView view = new ClassRosterView(io);
        ClassRosterDao dao = new ClassRosterDaoFileImpl();
        ClassRosterAuditDao audit = new ClassRosterAuditDaoFileImpl();
        ClassRosterServiceLayer service = new ClassRosterServiceLayerImpl(dao, audit);
        ClassRosterController controller = new ClassRosterController(view, service);
        controller.run();
    }
}
