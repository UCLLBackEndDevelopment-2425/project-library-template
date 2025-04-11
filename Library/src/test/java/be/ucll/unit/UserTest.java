package be.ucll.unit;

import be.ucll.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    public void givenValidValues_whenCreatingUser_thenUserIsCreatedWithThoseValues() {
        User user = new User("John Doe", 56, "john.doe@ucll.be", "john1234");
        assertEquals("John Doe", user.getName());
        assertEquals(56, user.getAge());
        assertEquals("john.doe@ucll.be", user.getEmail());
        assertEquals("john1234", user.getPassword());
    }

    @Test
    public void givenAUser_whenSettingValidValues_thenUserHasTheSameValues() {
        User user = new User("John Doe", 56, "john.doe@ucll.be", "john1234");

        user.setName("Johnny");
        assertEquals("Johnny", user.getName());

        user.setAge(22);
        assertEquals(22, user.getAge());

        user.setEmail("j.d@ucll.be");
        assertEquals("j.d@ucll.be", user.getEmail());

        user.setPassword("SafePW123");
        assertEquals("SafePW123", user.getPassword());
    }



    @Test
    public void givenaUser_whenSettingNameToEmpty_thenExpectException() {
        User user = new User("John Doe", 56, "john.doe@ucll.be", "john1234");

        Exception ex = assertThrows(RuntimeException.class, () -> user.setName(""));
        assertEquals("Name is required", ex.getMessage());
    }

    @Test
    public void givenaUser_whenSettingNameToNull_thenExpectException() {
        User user = new User("John Doe", 56, "john.doe@ucll.be", "john1234");

        Exception ex = assertThrows(RuntimeException.class, () -> user.setName(null));
        assertEquals("Name is required", ex.getMessage());
    }

    @Test
    public void givenaUser_whenSettingPasswordToNull_thenExpectException() {
        User user = new User("John Doe", 56, "john.doe@ucll.be", "john1234");

        Exception ex = assertThrows(RuntimeException.class, () -> user.setPassword(null));
        assertEquals("Password is required", ex.getMessage());
    }

    @Test
    public void givenaUser_whenSettingPasswordShorterthan8Chars_thenExpectException() {
        User user = new User("John Doe", 56, "john.doe@ucll.be", "john1234");

        Exception ex = assertThrows(RuntimeException.class, () -> user.setPassword("1234567"));
        assertEquals("Password is required", ex.getMessage());
    }

    @Test
    public void givenaUser_whenSettingEmailToEmpty_thenExpectException() {
        User user = new User("John Doe", 56, "john.doe@ucll.be", "john1234");

        Exception ex = assertThrows(RuntimeException.class, () -> user.setEmail(""));
        assertEquals("E-mail must be a valid email format", ex.getMessage());
    }

    @Test
    public void givenaUser_whenSettingEmailToNull_thenExpectException() {
        User user = new User("John Doe", 56, "john.doe@ucll.be", "john1234");

        Exception ex = assertThrows(RuntimeException.class, () -> user.setEmail(null));
        assertEquals("E-mail must be a valid email format", ex.getMessage());
    }

    @Test
    public void givenaUser_whenSettingEmailWithInvalidFormats_thenExpectException() {
        User user = new User("John Doe", 56, "john.doe@ucll.be", "john1234");

        Exception ex = assertThrows(RuntimeException.class, () -> user.setEmail("jj.com"));
        assertEquals("E-mail must be a valid email format", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> user.setEmail("jj@com"));
        assertEquals("E-mail must be a valid email format", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () -> user.setEmail("jjcom"));
        assertEquals("E-mail must be a valid email format", ex.getMessage());
    }

    @Test
    public void givenaUser_whenSettingAgeToNegativeNumber_thenExpectException() {
        User user = new User("John Doe", 56, "john.doe@ucll.be", "john1234");

        Exception ex = assertThrows(RuntimeException.class, () -> user.setAge(-1));
        assertEquals("Age must be a positive integer between 0 and 101", ex.getMessage());
    }

    @Test
    public void givenaUser_whenSettingAgeToHunderdAndOne_thenExpectException() {
        User user = new User("John Doe", 56, "john.doe@ucll.be", "john1234");

        Exception ex = assertThrows(RuntimeException.class, () -> user.setAge(101));
        assertEquals("Age must be a positive integer between 0 and 101", ex.getMessage());
    }

}
