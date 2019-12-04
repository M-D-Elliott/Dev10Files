package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.IClassRosterAuditDao;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;
import com.sg.classroster.dao.IClassRosterDao;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.service.IClassRosterServiceLayer;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        IClassRosterDao myDao = new ClassRosterDao();
        IClassRosterAuditDao myAuditDao = new ClassRosterAuditDao();
        IClassRosterServiceLayer myService = new ClassRosterServiceLayer(myDao, myAuditDao);
        ClassRosterController controller = 
            new ClassRosterController(myService, myView);
        controller.run();
    }   
}
