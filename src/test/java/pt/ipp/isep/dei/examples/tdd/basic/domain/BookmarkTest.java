package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BookmarkTest {

    @Test
    public void TestAddWithValidUrl() {
        // Act
        boolean result = new Bookmark().saveUrl("https://www.facebook.com/");
        // Assert
        assertTrue(result);
    }

    @Test
    public void TestAddWithInvalidUrl() {
        // Act
        boolean result = new Bookmark().saveUrl("dhdhdebook.com/");
        // Assert
        assertFalse(result);
    }

    @Test
    public void TestValidatedUrlWithInvalidUrl() {
        // Act
        boolean result = new Bookmark().validateUrl("httjhgoogle.com/");
        // Assert
        assertFalse(result);
    }

    @Test
    public void TestValidateUrlWithValidUrl() {
        // Act
        boolean result = new Bookmark().validateUrl("https://www.google.com/");
        // Assert
        assertTrue(result);
    }

    @Test
    public void TestTagWithValidUrl() {
        // check if url exist, if not add , otherwise save tag
        boolean result = new Bookmark().tagUrl("tag", "https://www.facebook.com");
        assertTrue(result);
    }

    @Test
    public void TestTagWithInvalidUrl() {
        // check if url exist, if not add , otherwise save tag
        boolean result = new Bookmark().tagUrl("tag", "hbbt.facebook.com");
        assertFalse(result);
    }

    @Test
    public void testIsUrlExistedWithNewUrl() {
        Bookmark bookmark = new Bookmark();
        bookmark.saveUrl("https://www.facebook.com/");
        boolean result = new Bookmark().doesUrlExist("https://www.facebook.com/");
        assertFalse(result);
    }
}



