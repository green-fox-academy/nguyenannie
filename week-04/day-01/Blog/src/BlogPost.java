public class BlogPost {
    String authorName;
    String title;
    String text;
    String publicationDate;

    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }
    public String getAuthorName(String authorName){
        return this.authorName;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(String title){
        return this.title;
    }

    public void setText(String text){
        this.text = text;
    }
    public String getText(String text){
        return this.text;
    }

    public void setPublicationDate(String publicationDate){
        this.publicationDate = publicationDate;
    }
    public String getPublicationDate(String publicationDate) {
        return this.publicationDate;
    }
}
