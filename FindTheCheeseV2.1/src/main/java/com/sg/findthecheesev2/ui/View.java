package com.sg.findthecheesev2.ui;

import com.sg.findthecheesev2.game.ui.*;
import com.sg.bugsafari.models.Bug;
import java.util.List;

public class View {

    private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }
    
    public int displayMenuAndSelect() {
        io.encaseInBanner("Main Menu");
        io.print("1. Add a Bug.");
        io.print("2. Edit a Bug.");
        io.print("3. Delete a Bug.");
        io.print("4. List all bugs.");
        io.print("[0 to Exit]");
        return io.readInt("Please enter a command. 0-4");
    }

    public void sayGoodbye() {
        io.encaseInBanner("Goodbye!");
    }

    public Bug makeBug() {
        io.encaseInBanner("Add a bug!");
        
        Bug bug = new Bug();
        bug.setCommonName(io.readString("Common name:"));
        bug.setLatinName(io.readString("Latin name:"));
        
        return bug;
    }

    public void createSuccess(Bug bug) {
        io.encaseInBanner(bug.getCommonName() + " created!");
    }

    public void fail(){
        fail("Action failed.");
    }
    
    public void fail(String message) {
         System.out.println(message);
    }

    public void display(List<Bug> all) {
        io.encaseInBanner("All Bugs:");
        
        if(all.size() == 0){
            io.print("No bugs found");
            return;
        }
        
        all.forEach((b) -> {
            io.print(b.getId() + ": " + b.getCommonName() + ", " + b.getLatinName());
        });
    }

    public int getUpdateBugId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
