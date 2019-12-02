
package com.sg.moviedatabase.ui;

import com.sg.moviedatabase.dto.Movie;
import java.util.List;

public class MoviesView {
    UserIO io;

    public MoviesView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add new Movie");
        io.print("2. Create New Movie");
        io.print("3. View a Movie");
        io.print("4. Remove a Movie");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }
    
    public Movie getNewMovieInfo() {
        return new Movie();
    }
    
    public void displayCreateMovieBanner() {
        io.print(io.encaseInBanner("Create Movie"));
    }
    
    public void displayCreateSuccessBanner() {
        io.readString(
            "Movie successfully created.  Please hit enter to continue");
    }
    
    public void displayMovieList(List<Movie> movieList) {
        movieList.forEach((currentMovie) -> {
            io.print(currentMovie.getId() + ": "
                    + currentMovie.getTitle() + " "
                    + currentMovie.getReleaseDate());
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
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
