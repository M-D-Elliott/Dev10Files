
package com.sg.moviedatabase.ui;

import com.sg.moviedatabase.dto.Movie;
import java.util.List;

public class MoviesView {
    private IUserIO io;

    public MoviesView(IUserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add new Movie");
        io.print("2. View a Movie");
        io.print("3. Remove a Movie");
        io.print("4. List All Movies");
        io.print("0. Exit");

        return io.readInt("Please select from the above choices.", 0, 4);
    }
    
    public Movie getNewMovieInfo() {
        Movie newMovie = new Movie();
        newMovie.setTitle(io.readString("Title?"));
        newMovie.setReleaseDate(io.readString("Date of release?"));
        newMovie.setRating(io.readString("MPAA rating?"));
        newMovie.setDirectorName(io.readString("Director name?"));
        newMovie.setStudioName(io.readString("Studio name?"));
        newMovie.setUserRating(io.readString("Notes or user rating?"));
        return newMovie;
    }
    
    public void displayCreateMovieBanner() {
        io.encaseInBanner("Create Movie");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("Movie successfully created.  Please hit enter to continue");
    }
    
    public void displayMovieList(List<Movie> movieList) {
        movieList.forEach((currentMovie) -> {
            io.print(currentMovie.getId() + ": "
                    + currentMovie.getTitle() + " --Released "
                    + currentMovie.getReleaseDate() + "--");
        });
        io.readString("Please hit enter to continue.");
    }
    
    public void displayAllBanner() {
        io.encaseInBanner("Display All Movies");
    }
    
    public void displayMovieBanner () {
        io.encaseInBanner("Display Movie");
    }

    public int getMovieIdChoice() {
        return io.readInt("Please enter the Movie ID.");
    }

    public void displayMovie(Movie movie) {
        if (movie != null) {
            io.print(movie.getId());
            io.print(movie.getTitle());
            io.print("");
        } else {
            io.print("No such movie.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveMovieBanner () {
        displayRemoveBanner("Movie");
    }
    
    public void displayRemoveBanner (String item) {
        io.encaseInBanner("Remove " + item);
    }

    public void displayRemoveSuccessBanner () {
        io.readString("Movie successfully removed. Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(){
        displayErrorMessage("");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
