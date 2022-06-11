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

    @Test
    public void TestRefreshAssociates() {
        // Arrange
        Main main = new Main();
        String mainUrl = "https://www.facebook.com";
        String[] testUrls = {
                "https://www.facebook.com/subfolder1",
                "https://www.facebook.com/subfolder2",
                "https://www.facebook.com/subfolder3",
                "https://www.google.com/subfolder1",
                "https://www.google.com/subfolder2"
        };

        main.bookmarkUrl(mainUrl);
        for (String url : testUrls) {
            main.bookmarkUrl(url);
        }
        main.refreshAssociates();
        int expectedResult = 3;

        // Assert
        assertEquals(expectedResult, main.bookmarks.get(0).associatedBookmarks.size());
    }

    @Test
    public void TestFilterBookmarks() {
        // Arrange
        Main main = new Main();
        String filterKeyword = "face";
        String mainUrl = "https://www.facebook.com";
        String[] testUrls = {
                "https://www.facebook.com/subfolder1",
                "https://www.facebook.com/subfolder2",
                "https://www.facebook.com/subfolder3",
                "https://www.google.com/subfolder1",
                "https://www.google.com/subfolder2"
        };

        main.bookmarkUrl(mainUrl);
        for (String url : testUrls) {
            main.bookmarkUrl(url);
        }

        int expectedResult = 4;

        // Assert
        assertEquals(expectedResult, main.filterBookmarks(filterKeyword).size());
    }

    @Test
    public void TestFilterBookmarksByMultipleKeywords() {
        // Arrange
        Main main = new Main();
        String[] filterKeywords = {"face","goo","micro"};
        String mainUrl = "https://www.facebook.com";
        String[] testUrls = {
                "https://www.facebook.com/subfolder1",
                "https://www.facebook.com/subfolder2",
                "https://www.facebook.com/subfolder3",
                "https://www.google.com/subfolder1",
                "https://www.microsoft.com/subfolder2",
                "https://www.microsoft.com/subfolder2",
                "https://www.yahoo.com/subfolder2",
                "https://www.yahoo.com/subfolder2"
        };

        main.bookmarkUrl(mainUrl);
        for (String url : testUrls) {
            main.bookmarkUrl(url);
        }

        int expectedResult = 6;

        // Assert
        assertEquals(expectedResult, main.filterBookmarksByMultipleKeywords(filterKeywords).size());
    }
}
