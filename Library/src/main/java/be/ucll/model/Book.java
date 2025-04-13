package be.ucll.model;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    public Book(String title, String author, String isbn, int publicationYear) {
        setTitle(title);
        setAuthor(author);
        setISBN(isbn);
        setPublicationYear(publicationYear);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new RuntimeException("Title is required");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new RuntimeException("Author is required");
        }
        this.author = author;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        if (!isbnIsValid(isbn)) {
            throw new RuntimeException("ISBN is required");
        }
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        if (publicationYear > LocalDate.now().getYear()) {
            throw new RuntimeException("Publication year cannot be in the future");
        }
        this.publicationYear = publicationYear;
    }
  
    private boolean isbnIsValid(String isbn) {
        if (isbn == null || isbn.length() < 13) {
            return false;
        }
        String cleanIsbn = isbn
                .trim()
                .replace("-", "");
        return cleanIsbn.length() == 13;
    }
}
