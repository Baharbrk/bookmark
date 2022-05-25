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

    @Test
    public void TestBookmarkDuplicateUrl() {
        // Act
        String url = "https://google.com";
        Main main = new Main();
        main.bookmarkUrl(url);
        main.bookmarkUrl(url);

        // Assert
        assertEquals(1, main.bookmarks.get(0).rate);
    }

    @Test
    public void TestCountSecureBookmarks() {
        // Act
        String unsecureUrl1 = "http://google.com";
        String secureUrl1 = "https://google.com";
        String unsecureUrl2 = "http://facebook.com";
        String secureUrl2 = "https://facebook.com";
        String unsecureUrl3 = "http://twitter.com";
        String secureUrl3 = "https://twitter.com";
        String secureUrl4 = "https://microsoft.com";

        Main main = new Main();
        main.bookmarkUrl(unsecureUrl1);
        main.bookmarkUrl(secureUrl1);
        main.bookmarkUrl(unsecureUrl2);
        main.bookmarkUrl(secureUrl2);
        main.bookmarkUrl(unsecureUrl3);
        main.bookmarkUrl(secureUrl3);
        main.bookmarkUrl(secureUrl4);

        // Assert
        assertEquals(4, main.countSecureBookmarks());
    }
}
