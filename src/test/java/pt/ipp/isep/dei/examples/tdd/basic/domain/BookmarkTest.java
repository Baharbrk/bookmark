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
// write first what you wanna do , check if I do this I get this
    @Test
    public void TestAddWithInvalidUrl() {
        // Act
        boolean result = new Bookmark().saveUrl("dhdhdebook.com/");
        // Assert
        assertFalse(result);
    }

    @Test
    public void TestTagWithValidUrl() {
        // check if url exist, if not add , otherwise save tag
        boolean result = new Bookmark().tagUrl("tag", "https://www.facebook.com");
        assertTrue(result); // get list of tags from bookmark , check if the count is as same as expected ,
        // we don't know if the tag  is really saved => we should check if it is saved
        // bookmark , tag class, url class
        // list of bookmarks => list of bookmark class
    }

    @Test
    public void TestTagWithInvalidUrl() {
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

