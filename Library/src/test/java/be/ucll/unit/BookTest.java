package be.ucll.unit;

import be.ucll.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookTest {
    @Test
    public void givenValidValues_whenCreatingBook_thenBookIsCreatedWithThoseValues() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 1999);
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("978-0-545-01022-1", book.getISBN());
        assertEquals(1999, book.getPublicationYear());
    }

    @Test
    public void givenABook_whenSettingTitleWithInvalidValues_thenExceptionIsThrown() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 1999);

        Exception ex = assertThrows(RuntimeException.class, () -> book.setTitle(""));
        assertEquals("Title is required", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> book.setTitle(null));
        assertEquals("Title is required", ex.getMessage());
    }

    @Test
    public void givenABook_whenSettingAuthorWithInvalidValues_thenExceptionIsThrown() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 1999);

        Exception ex = assertThrows(RuntimeException.class, () -> book.setAuthor(""));
        assertEquals("Author is required", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> book.setAuthor(null));
        assertEquals("Author is required", ex.getMessage());
    }

    @Test
    public void givenABook_whenSettingISBNWithInvalidValues_thenExceptionIsThrown() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 1999);

        Exception ex = assertThrows(RuntimeException.class, () -> book.setISBN(""));
        assertEquals("ISBN is required", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> book.setISBN(null));
        assertEquals("ISBN is required", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> book.setISBN("123"));
        assertEquals("ISBN is required", ex.getMessage());
    }

    @Test
    public void givenABook_whenSettingPublicationYearWithInvalidValues_thenExceptionIsThrown() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 1999);

        int nextYear = java.time.LocalDate.now().getYear() + 1;

        Exception ex = assertThrows(RuntimeException.class, () -> book.setPublicationYear(nextYear));
        assertEquals("Publication year cannot be in the future", ex.getMessage());

    }
}
