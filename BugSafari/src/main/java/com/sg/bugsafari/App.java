package com.sg.bugsafari;

import com.sg.bugsafari.controllers.Controller;
import com.sg.bugsafari.data.BugDao;
import com.sg.bugsafari.data.DataException;
import com.sg.bugsafari.ui.UserIO;
import com.sg.bugsafari.ui.UserIOConsoleImpl;
import com.sg.bugsafari.ui.View;

public class App {
    public static void main(String[] args) throws DataException {
        UserIO io = new UserIOConsoleImpl();
        
        View view = new View(io);
        BugDao dao = new BugDao();
        Controller controller = new Controller(view, dao);
        
        controller.run();
    }
}
