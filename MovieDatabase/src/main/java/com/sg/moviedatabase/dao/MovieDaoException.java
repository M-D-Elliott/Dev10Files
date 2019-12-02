
package com.sg.moviedatabase.dao;

public class MovieDaoException extends Throwable {
    public MovieDaoException(String message) {
        super(message);
    }
    
    public MovieDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
