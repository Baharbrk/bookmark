package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BookmarkTest {

    @Test
    public void TestAddUrl() {
        // Act
        boolean result = new Bookmark.saveUrl("https://www.facebook.com/");
        // Assert
        assertTrue(result);
    }

    @Test
    public void TestValidatedUrlWithInvalidUrl() {
        // Act
        boolean result = new Bookmark.validateUrl("httpsgoogle.com/");
        // Assert
        assertFalse(result);
    }

    @Test
    public void TestValidateUrlWithValidUrl() {
        // Act
        boolean result = new Bookmark.validateUrl("https://www.google.com/");
        // Assert
        assertTrue(result);
    }
}



