package be.ucll.unit;

import be.ucll.model.Magazine;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MagazineTest {
    @Test
    public void givenValidValues_whenCreatingMagazine_thenMagazineIsCreatedWithThoseValues() {
        Magazine magazine = new Magazine("Science Weekly", "Jane Smith", "1234-5678", 2022);
        assertEquals("Science Weekly", magazine.getTitle());
        assertEquals("Jane Smith", magazine.getEditor());
        assertEquals("1234-5678", magazine.getISSN());
        assertEquals(2022, magazine.getPublicationYear());
    }

    @Test
    public void givenAMagazine_whenSettingTitleWithInvalidValues_thenExceptionIsThrown() {
        Magazine magazine = new Magazine("Science Weekly", "Jane Smith", "1234-5678", 2022);

        Exception ex = assertThrows(RuntimeException.class, () -> magazine.setTitle(""));
        assertEquals("Title is required", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> magazine.setTitle(null));
        assertEquals("Title is required", ex.getMessage());
    }

    @Test
    public void givenAMagazine_whenSettingEditorWithInvalidValues_thenExceptionIsThrown() {
        Magazine magazine = new Magazine("Science Weekly", "Jane Smith", "1234-5678", 2022);

        Exception ex = assertThrows(RuntimeException.class, () -> magazine.setEditor(""));
        assertEquals("Editor is required", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> magazine.setEditor(null));
        assertEquals("Editor is required", ex.getMessage());
    }

    @Test
    public void givenAMagazine_whenSettingISSNWithInvalidValues_thenExceptionIsThrown() {
        Magazine magazine = new Magazine("Science Weekly", "Jane Smith", "1234-5678", 2022);

        Exception ex = assertThrows(RuntimeException.class, () -> magazine.setISSN(""));
        assertEquals("ISSN is required", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> magazine.setISSN(null));
        assertEquals("ISSN is required", ex.getMessage());
    }

    @Test
    public void givenAMagazine_whenSettingNegativePublicationYear_thenExceptionIsThrown() {
        Magazine magazine = new Magazine("Science Weekly", "Jane Smith", "1234-5678", 2022);

        Exception ex = assertThrows(RuntimeException.class, () -> magazine.setPublicationYear(-1));
        assertEquals("Publication year must be a positive integer", ex.getMessage());
    }

    @Test
    public void givenAMagazine_whenSettingZeroPublicationYear_thenExceptionIsThrown() {
        Magazine magazine = new Magazine("Science Weekly", "Jane Smith", "1234-5678", 2022);

        Exception ex = assertThrows(RuntimeException.class, () -> magazine.setPublicationYear(0));
        assertEquals("Publication year must be a positive integer", ex.getMessage());
    }

    @Test
    public void givenAMagazine_whenSettingFuturePublicationYear_thenExceptionIsThrown() {
        Magazine magazine = new Magazine("Science Weekly", "Jane Smith", "1234-5678", 2022);

        int nextYear = LocalDate.now().getYear() + 1;
        Exception ex = assertThrows(RuntimeException.class, () -> magazine.setPublicationYear(nextYear));
        assertEquals("Publication year cannot be in the future", ex.getMessage());
    }
}