package com.sg.moviedatabase.dao;

import com.sg.moviedatabase.dto.Movie;
import java.util.ArrayList;
import java.util.List;

public class MovieDao implements IMovieDao {

    private List<Movie> movies;
    private static final String MOVIES_DB = "moviesDB.txt";
    private static final String DELIMITER = "::";

    private IFileIO io;

    public MovieDao(IFileIO io) {
        this.movies = new ArrayList<>();
        this.io = io;
    }

    @Override
    public Movie addMovie(int movieId, Movie movie) throws MovieDaoException {
        loadMovies();
        movies.add(movie);
        writeMovies();
        return movie;
    }

    @Override
    public List<Movie> getAllMovies() throws MovieDaoException {
        loadMovies();
        return movies;
    }

    @Override
    public Movie getMovie(int movieId) {
        return movies.get(movieId);
    }

    @Override
    public Movie removeMovie(int movieId) throws MovieDaoException {
        loadMovies();
        Movie movie = movies.remove(movieId);
        writeMovies();
        return movie;
    }

    private void loadMovies() throws MovieDaoException {

        List<String> moviesFile = io.readFile(MOVIES_DB);
        movies = new ArrayList<>();
        Movie.resetTotal();
        
        Movie currentMovie;
        for (String line : moviesFile) {
            currentMovie = unmarshallMovie(line);
            movies.add(currentMovie);

        }
    }

    private void writeMovies() throws MovieDaoException {

        String movieAsText;
        List<String> marshalledMovies = new ArrayList<>();
        for (Movie movie : movies) {
            movieAsText = marshallMovie(movie);
            marshalledMovies.add(movieAsText);
        }

        io.writeFile(MOVIES_DB, marshalledMovies);
    }

    private Movie unmarshallMovie(String line) {
        String[] lineAsArray = line.split(DELIMITER);
        
        Movie newMovie = new Movie();
        newMovie.setTitle(lineAsArray[0]);
        newMovie.setReleaseDate(lineAsArray[1]);
        newMovie.setRating(lineAsArray[2]);
        newMovie.setDirectorName(lineAsArray[3]);
        newMovie.setStudioName(lineAsArray[4]);
        newMovie.setUserRating(lineAsArray[5]);
        
        return newMovie;
    }

    private String marshallMovie(Movie movie) {
        String marshalledMovie = "";
        marshalledMovie += movie.getTitle() + DELIMITER;
        marshalledMovie += movie.getReleaseDate() + DELIMITER;
        marshalledMovie += movie.getRating() + DELIMITER;
        marshalledMovie += movie.getDirectorName() + DELIMITER;
        marshalledMovie += movie.getStudioName() + DELIMITER;
        marshalledMovie += movie.getUserRating() + DELIMITER;
                
        return marshalledMovie;
    }
}
