package ee.taltech.iti0202.tk2.art;

public class Painting {
    private String title;
    private String author = null;
    public Collector owner = null;

    public Painting(String title) {
        this.title = title;
    }

    public Painting(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
            return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        if (this.getAuthor() == null) {
            return "This is a painting named " + this.title + " and made by an unknown artist.";
        } else {
            return "This is a painting named " + this.title + " and made by " + this.author + ".";
        }
    }
}
