
package com.sg.moviedatabase.controllers;

import com.sg.moviedatabase.dao.MovieDaoException;
import com.sg.moviedatabase.dao.MoviesDao;
import com.sg.moviedatabase.dto.Movie;
import com.sg.moviedatabase.ui.MoviesView;
import java.util.List;

public class MoviesController {
    
    MoviesView view;
    MoviesDao dao;

    public MoviesController(MoviesDao dao, MoviesView view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listMovies();
                        break;
                    case 2:
                        createMovie();
                        break;
                    case 3:
                        viewMovie();
                        break;
                    case 4:
                        removeMovie();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (MovieDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createMovie() throws MovieDaoException {
        view.displayCreateMovieBanner();
        Movie newMovie = view.getNewMovieInfo();
        dao.addMovie(newMovie.getId(), newMovie);
        view.displayCreateSuccessBanner();
    }

    private void listMovies() throws MovieDaoException {
        view.displayAllBanner();
        List<Movie> movieList = dao.getAllMovies();
        view.displayMovieList(movieList);
    }

    private void viewMovie() throws MovieDaoException {
        view.displayMovieBanner();
        int movieId = view.getMovieIdChoice();
        Movie movie = dao.getMovie(movieId);
        view.displayMovie(movie);
    }

    private void removeMovie() throws MovieDaoException {
        view.displayRemoveMovieBanner();
        int movieId = view.getMovieIdChoice();
        dao.removeMovie(movieId);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
