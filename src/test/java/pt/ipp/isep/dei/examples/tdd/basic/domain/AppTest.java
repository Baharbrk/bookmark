package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void TestBookmarkUrl() {
        // Act
        String url = "https://google.com";
        App app = new App();
        app.bookmarkUrl(url);

        // Assert
        assertEquals(url, app.bookmarks.get(0).url.givenUrl);
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

        App app = new App();
        app.bookmarkUrl(unsecureUrl1);
        app.bookmarkUrl(secureUrl1);
        app.bookmarkUrl(unsecureUrl2);
        app.bookmarkUrl(secureUrl2);
        app.bookmarkUrl(unsecureUrl3);
        app.bookmarkUrl(secureUrl3);
        app.bookmarkUrl(secureUrl4);

        // Assert
        assertEquals(4, app.countSecureBookmarks());
    }

    @Test
    public void TestRefreshAssociates() {
        // Arrange
        App app = new App();
        String mainUrl = "https://www.facebook.com";
        String[] testUrls = {
                "https://www.facebook.com/subfolder1",
                "https://www.facebook.com/subfolder2",
                "https://www.facebook.com/subfolder3",
                "https://www.google.com/subfolder1",
                "https://www.google.com/subfolder2"
        };

        app.bookmarkUrl(mainUrl);
        for (String url : testUrls) {
            app.bookmarkUrl(url);
        }
        app.refreshAssociates();
        int expectedResult = 3;

        // Assert
        assertEquals(expectedResult, app.bookmarks.get(0).associatedBookmarks.size());
    }

    @Test
    public void TestFilterBookmarks() {
        // Arrange
        App app = new App();
        String filterKeyword = "face";
        String mainUrl = "https://www.facebook.com";
        String[] testUrls = {
                "https://www.facebook.com/subfolder1",
                "https://www.facebook.com/subfolder2",
                "https://www.facebook.com/subfolder3",
                "https://www.google.com/subfolder1",
                "https://www.google.com/subfolder2"
        };

        app.bookmarkUrl(mainUrl);
        for (String url : testUrls) {
            app.bookmarkUrl(url);
        }

        int expectedResult = 4;

        // Assert
        assertEquals(expectedResult, app.filterBookmarks(filterKeyword).size());
    }

    @Test
    public void TestFilterBookmarksByMultipleKeywords() {
        // Arrange
        App app = new App();
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

        app.bookmarkUrl(mainUrl);
        for (String url : testUrls) {
            app.bookmarkUrl(url);
        }

        int expectedResult = 6;

        // Assert
        assertEquals(expectedResult, app.filterBookmarksByMultipleKeywords(filterKeywords).size());
    }
}
