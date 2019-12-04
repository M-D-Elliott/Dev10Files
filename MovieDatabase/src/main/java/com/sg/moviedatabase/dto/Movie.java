
package com.sg.moviedatabase.dto;

//enum mpaaRating {
//    G,
//    PG,
//    PG13,
//    R,
//    NC17,
//}

public class Movie {
    private String Title;
    private String releaseDate;
    private String rating;
    private String directorName;
    private String studioName;
    private String userRating;
    
    private int id;
    
    private static int totalMovies;

    public Movie() {
        totalMovies++;
        this.id = totalMovies;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public int getId() {
        return id;
    }
    
    public static void resetTotal(){
        totalMovies = 0;
    }
}
