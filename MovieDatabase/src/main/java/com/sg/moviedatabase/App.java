
package com.sg.moviedatabase;

import com.sg.moviedatabase.controllers.MoviesController;
import com.sg.moviedatabase.dao.FileIO;
import com.sg.moviedatabase.dao.IFileIO;
import com.sg.moviedatabase.dao.MovieDao;
import com.sg.moviedatabase.ui.MoviesView;
import com.sg.moviedatabase.ui.UserIO;
import com.sg.moviedatabase.ui.IUserIO;
import com.sg.moviedatabase.dao.IMovieDao;

public class App {
    public static void main(String[] args) {
        IUserIO userIO = new UserIO();
        MoviesView movieView = new MoviesView(userIO);
        
        IFileIO fileIO = new FileIO();
        IMovieDao movieDao = new MovieDao(fileIO);
        
        MoviesController controller = 
            new MoviesController(movieDao, movieView);
        controller.run();
    }
}
