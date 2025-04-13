package be.ucll.model;

public class Book extends Publication {
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn, int publicationYear, int availableCopies) {
        super(title, publicationYear, availableCopies);
        setAuthor(author);
        setISBN(isbn);
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
