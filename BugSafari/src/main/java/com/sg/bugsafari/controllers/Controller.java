package com.sg.bugsafari.controllers;

import com.sg.bugsafari.data.DataException;
import com.sg.bugsafari.data.IBugDao;
import com.sg.bugsafari.models.Bug;
import com.sg.bugsafari.ui.View;
import java.util.List;

public class Controller {
    private final View view;
    private final IBugDao dao;
    
    public Controller(View view, IBugDao dao){
        this.view = view;
        this.dao = dao;
    }

    public void run() throws DataException {
        // doing io in controller. not great, but using for now.
        int selection = 0;
        do{
            selection = view.displayMenuAndSelect();
            switch(selection){
                case 1:
                   addBug();
                    break;
                case 2:
                    editBug();
                    break;
                case 3:
                    //delete
                    break;
                case 4:
                    listAllBugs();
                    break;
            }
        }while(selection > 0);
        
        view.sayGoodbye();
    }

    private void addBug() throws DataException {
        Bug bug = view.makeBug();
        bug = dao.create(bug);
        if(bug.getId() > 0){
            view.createSuccess(bug);
        } else {
            view.fail();
        }
    }

    private void listAllBugs() throws DataException {
        List<Bug> all = dao.findAll();
        view.display(all);
    }

    private void editBug() {
        int bugId = view.getUpdateBugId();
        Bug bug = dao.findById(bugId);
        if(bug == null){
            view.fail("Bug Id: " + bugId + " not found.");
            return;
        }
    }
}
