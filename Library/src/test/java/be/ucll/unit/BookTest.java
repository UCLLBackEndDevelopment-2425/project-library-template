package be.ucll.unit;

import be.ucll.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookTest {
    @Test
    public void givenValidValues_whenCreatingBook_thenBookIsCreatedWithThoseValues() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 1999, 2);
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("978-0-545-01022-1", book.getISBN());
        assertEquals(1999, book.getPublicationYear());
        assertEquals(2, book.getAvailableCopies());

        Book bookWithCopies = new Book("Title", "Author", "978-0-545-01022-1", 1999, 5);
        assertEquals(5, bookWithCopies.getAvailableCopies());
    }

    @Test
    public void givenABook_whenSettingTitleWithInvalidValues_thenExceptionIsThrown() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 1999, 2);

        Exception ex = assertThrows(RuntimeException.class, () -> book.setTitle(""));
        assertEquals("Title is required", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> book.setTitle(null));
        assertEquals("Title is required", ex.getMessage());
    }

    @Test
    public void givenABook_whenSettingAuthorWithInvalidValues_thenExceptionIsThrown() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 1999, 2);

        Exception ex = assertThrows(RuntimeException.class, () -> book.setAuthor(""));
        assertEquals("Author is required", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> book.setAuthor(null));
        assertEquals("Author is required", ex.getMessage());
    }

    @Test
    public void givenABook_whenSettingISBNWithInvalidValues_thenExceptionIsThrown() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 1999, 2);

        Exception ex = assertThrows(RuntimeException.class, () -> book.setISBN(""));
        assertEquals("ISBN is required", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> book.setISBN(null));
        assertEquals("ISBN is required", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> book.setISBN("123"));
        assertEquals("ISBN is required", ex.getMessage());
    }

    @Test
    public void givenABook_whenSettingPublicationYearWithInvalidValues_thenExceptionIsThrown() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 1999, 2);

        int nextYear = java.time.LocalDate.now().getYear() + 1;

        Exception ex = assertThrows(RuntimeException.class, () -> book.setPublicationYear(nextYear));
        assertEquals("Publication year cannot be in the future", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> book.setPublicationYear(0));
        assertEquals("Publication year must be a positive integer", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> book.setPublicationYear(-1));
        assertEquals("Publication year must be a positive integer", ex.getMessage());
    }

    @Test
    public void givenABook_whenSettingAvailableCopiesWithInvalidValues_thenExceptionIsThrown() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 1999, 2);

        Exception ex = assertThrows(RuntimeException.class, () -> book.setAvailableCopies(-1));
        assertEquals("Number of available copies must be a positive integer", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> book.setAvailableCopies(0));
        assertEquals("Number of available copies must be a positive integer", ex.getMessage());
    }
}
