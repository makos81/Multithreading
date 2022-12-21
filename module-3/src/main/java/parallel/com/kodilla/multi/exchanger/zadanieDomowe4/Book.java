package parallel.com.kodilla.multi.exchanger.zadanieDomowe4;

public final class Book {
    private String title;
    private String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + this.title + " author: " + this.author;
    }
}
