package exercises1;

import java.util.Arrays;

public class BookInLibraryCatalogue {
    private String author;
    private String title;
    private String publishDate;
    
    private String catalogueID;
    
    private String description;
    
    private int totalCopiesOwned;
    private int totalCopiesRented;
    
    private String[] rentees;

    public BookInLibraryCatalogue(String author, String title, String publishDate, String catalogueID, String description, int totalCopiesOwned, int totalCopiesRented) {
        this.author = author;
        this.title = title;
        this.publishDate = publishDate;
        this.catalogueID = catalogueID;
        this.description = description;
        this.totalCopiesOwned = totalCopiesOwned;
        this.totalCopiesRented = totalCopiesRented;
        setAvailableRentees(totalCopiesOwned);
    }

    public boolean isInStock(){
        return totalCopiesOwned - totalCopiesRented > 0;
    }
    
    public boolean checkOut(){
        if(isInStock()) {
            totalCopiesRented += 1;
            return true;
        }
        return false;
    }
    
    public void checkIn(){
        totalCopiesRented -= 1;
    }

    public String getAllDetails(){
        String details = "";
        details += "Title: " + title + "\n";
        details += "By: " + author + "\n";
        details += "Published on: " + publishDate + "\n";
        details += "Catalogue #: " + catalogueID + "\n";
        details += "\nRentees: " + "\n";
        for (String rentee : rentees) {
            details += rentee + "\n";
        }
        return details;
    }
    
    private String[] setAvailableRentees(int newTotalCopies) {
        String[] renteesTemp = {};
        if(rentees.length > 0){
            renteesTemp = rentees;
        }
        
        if(newTotalCopies < totalCopiesOwned){
        
        }
        rentees = new String[totalCopiesOwned];
        rentees[0] = Arrays.toString(renteesTemp);
        return rentees;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalCopiesOwned() {
        return totalCopiesOwned;
    }

    public void setTotalCopiesOwned(int totalCopiesOwned) {
        this.totalCopiesOwned = totalCopiesOwned;
    }

    public int getTotalCopiesRented() {
        return totalCopiesRented;
    }

    public void setTotalCopiesRented(int totalCopiesRented) {
        this.totalCopiesRented = totalCopiesRented;
    }

    public String getCatalogueID() {
        return catalogueID;
    }

    public void setCatalogueID(String catalogueID) {
        this.catalogueID = catalogueID;
    }
    
    
}
