package UDP;
import java.io.*;
public class Book implements Serializable{
    private static final long serialVersionUID = 20251107L;
    private String id, title, author, isbn, publishDate;
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publishDate=" + publishDate + '}';
    }
}
