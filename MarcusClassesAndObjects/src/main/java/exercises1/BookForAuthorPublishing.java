package exercises1;

public class BookForAuthorPublishing {
    private String author;
    private String title;
    private String publishDate;
    
    private String description;
    
    private boolean isPublished;
    private boolean needsReview;
    
    private int cost;

    public BookForAuthorPublishing(String author, String title, String publishDate, String description, boolean isPublished, boolean needsReview, int cost) {
        this.author = author;
        this.title = title;
        this.publishDate = publishDate;
        this.description = description;
        this.isPublished = isPublished;
        this.needsReview = needsReview;
        this.cost = cost;
    }
    
    public String getAllDetails(){
        String details = "";
        details += "Title: " + title + "\n";
        details += "By: " + author + "\n";
        details += "Published on: " + ((isPublished) ? publishDate : "N/A") + "\n";
        details += "Review requested: " + ((needsReview) ? "Yes" : "None") +"\n";
        return details;
    }
    
    public void publish(){
        setPublishDate(today());
        isPublished = true;
    }
    
    public void askForReview(){
        System.out.println("Reviewer Name?");
        setNeedsReview(true);
    }

    public String today() {
        return "today's date";
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

    public boolean isIsPublished() {
        return isPublished;
    }

    public void setIsPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public boolean isNeedsReview() {
        return needsReview;
    }

    public void setNeedsReview(boolean needsReview) {
        this.needsReview = needsReview;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
