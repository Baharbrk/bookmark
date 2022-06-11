package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;
import pt.ipp.isep.dei.examples.tdd.basic.ui.Main;
import static org.junit.jupiter.api.Assertions.*;

public class BookmarkTest {
    @Test
    public void TestAddWithValidUrl() {
        // Arrange
        String url = "https://www.facebook.com/";
        Url validUrl = new Url(url);
        String expectedResult = "https://www.facebook.com/";

        // Act
        Bookmark bookmark = new Bookmark(validUrl);
        String actualResult = bookmark.url.url;

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    // object should be removed once url is not valid
    @Test
    public void TestAddWithInvalidUrl() {
        // Arrange
        String url = "dhdhdebook.com/";
        Url invalidUrl = new Url(url);
        boolean expectedResult = false;

        // Act
        boolean actualResult = new Bookmark(invalidUrl).addUrl(invalidUrl);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddRate() {
        // Arrange
        String url = "https://www.facebook.com/";
        Url validUrl = new Url(url);
        int expectedResult = 1;

        // Act
        Bookmark bookmark = new Bookmark(validUrl);
        bookmark.addRate();
        int acutalResult = bookmark.rate;

        // Assert
        assertEquals(expectedResult, acutalResult);
    }

    @Test
    public void testGetHostname() {
        // Arrange
        Url url = new Url("https://www.facebook.com");
        String expectedResult = "facebook.com";

        // Act
        Bookmark bookmark = new Bookmark(url);
        String acutalResult = bookmark.getHostName();

        // Assert
        assertEquals(expectedResult, acutalResult);
    }
}
