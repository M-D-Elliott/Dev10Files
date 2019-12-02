
package com.sg.moviedatabase.dao;

import com.sg.moviedatabase.dto.Movie;
import java.util.List;

public interface MoviesDao {
         
    /**
     * Adds the given Movie to the database and associates it with the given 
     * movie id. If there is already a movie associated with the given 
     * movie id it will return that movie object, otherwise it will 
     * return null.
     * 
     * @param movieId id with which movie is to be associated
     * @param movie movie to be added to the database
     * @return the Movie object previously associated with the given  
     * movie id if it exists, null otherwise
     * @throws com.sg.moviedatabase.dao.MovieDaoException
     */
    Movie addMovie(int movieId, Movie movie) throws MovieDaoException;
    
    /**
     * Returns a String array containing the movie ids of all 
     * movies in the database.
     * 
     * @return String array containing the ids of all the movies 
     * in the database
     * @throws com.sg.moviedatabase.dao.MovieDaoException
     */
    List<Movie> getAllMovies() throws MovieDaoException;
    
    /**
     * Returns the movie object associated with the given movie id.
     * Returns null if no such movie exists
     * 
     * @param movieId ID of the movie to retrieve
     * @return the Movie object associated with the given movie id,  
     * null if no such movie exists
     */
    Movie getMovie(int movieId);
    
    /**
     * Removes from the database the movie associated with the given id. 
     * Returns the movie object that is being removed or null if 
     * there is no movie associated with the given id
     * 
     * @param movieId id of movie to be removed
     * @return Movie object that was removed or null if no movie 
     * was associated with the given movie id
     * @throws com.sg.moviedatabase.dao.MovieDaoException
     */
    Movie removeMovie(int movieId) throws MovieDaoException;
}
