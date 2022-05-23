package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BookmarkTest {

    @Test
    public void TestAddWithValidUrl() {
        // Arrange
        Url url = new Url();
        url.setUrl("https://www.facebook.com/");

        // Act
        boolean result = new Bookmark().saveUrl(url.getUrl());
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
}

