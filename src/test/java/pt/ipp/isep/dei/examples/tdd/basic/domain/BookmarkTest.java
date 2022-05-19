package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmarkTest {

    @Test
    public void TestAddUrl() {
        Bookmark.saveUrl result = new Bookmark.saveUrl("https://www.facebook.com/");
        // Assert
        assertEquals(true, result);
    }
}



