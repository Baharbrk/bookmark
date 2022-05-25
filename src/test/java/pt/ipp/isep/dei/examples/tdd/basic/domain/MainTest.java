package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;
import pt.ipp.isep.dei.examples.tdd.basic.ui.Main;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void TestBookmarkUrl() {
        // Act
        String url = "https://google.com";
        Main main = new Main();
        main.bookmarkUrl(url);

        // Assert
        assertEquals(url, main.bookmarks.get(0).url.url);
    }
}
