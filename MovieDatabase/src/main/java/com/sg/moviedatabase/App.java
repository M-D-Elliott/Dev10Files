
package com.sg.moviedatabase;

import com.sg.moviedatabase.controllers.MoviesController;
import com.sg.moviedatabase.dao.MovieDaoFileImpl;
import com.sg.moviedatabase.dao.MoviesDao;
import com.sg.moviedatabase.ui.MoviesView;
import com.sg.moviedatabase.ui.UserIO;
import com.sg.moviedatabase.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        MoviesView myView = new MoviesView(myIo);
        MoviesDao myDao = new MovieDaoFileImpl();
        MoviesController controller = 
            new MoviesController(myDao, myView);
        controller.run();
    }
}
