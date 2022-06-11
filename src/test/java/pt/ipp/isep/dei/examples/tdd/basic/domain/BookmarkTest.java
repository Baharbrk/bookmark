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
        int actualResult = bookmark.rate;

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetHostname() {
        // Arrange
        Url url = new Url("https://www.facebook.com");
        String expectedResult = "facebook.com";

        // Act
        Bookmark bookmark = new Bookmark(url);
        String actualResult = bookmark.getHostName();

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetHostnameWhenHostnameNull() {
        // Arrange
        Url url = new Url("https://www.hostwithü.com");
        String expectedResult = null;

        // Act
        Bookmark bookmark = new Bookmark(url);
        String hostname = bookmark.getHostName();
        String actualResult = hostname;

        // Assert
        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void testAssociatedBookmark() {
        // Arrange
        String mainUrl = "https://www.facebook.com";
        String[] testUrls = {
                "https://www.facebook.com/subfolder1",
                "https://www.facebook.com/subfolder2",
                "https://www.facebook.com/subfolder3",
                "https://www.google.com/subfolder1",
                "https://www.google.com/subfolder2"
        };

        Bookmark mainBookmark = new Bookmark(new Url(mainUrl));
        for(String url : testUrls) {
            mainBookmark.associateBookmark(new Bookmark(new Url(url)));
        }

        int expectedResult = 3;

        // Act
        int acutalResult = mainBookmark.associatedBookmarks.size();

        // Assert
        assertEquals(expectedResult, acutalResult);
    }

    @Test
    public void testRemoveTag() {
        // Arrange
        Url url = new Url("https://www.google.com/");
        Tag tag = new Tag("Google");
        Bookmark bookmark = new Bookmark(url);

        url.tagUrl(tag);
        url.tagUrl(new Tag("Google1"));
        url.tagUrl(new Tag("Google2"));
        bookmark.removeTag(tag);
        int expectedResult = 2;

        // Act
        int size = bookmark.url.tags.size();

        // Assert
        assertEquals(expectedResult, size);
    }

    @Test
    public void testRemoveUrl() {
        // Arrange
        Url url = new Url("https://www.google.com/");
        Bookmark bookmark = new Bookmark(url);

        // Act
        bookmark.removeUrl();

        // Assert
        assertNull(bookmark.url);
    }
}
