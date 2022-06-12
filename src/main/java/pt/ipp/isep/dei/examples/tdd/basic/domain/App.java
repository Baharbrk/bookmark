package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class App {

    public List<Bookmark> bookmarks = new ArrayList<>();

    public void bookmarkUrl(String url) {
        Bookmark bookmark = bookmarks.stream().filter(obj -> Objects.equals(obj.url.givenUrl, url)).findFirst().orElse(null);
        if (bookmark == null) {
            Url urlObj = new Url(url);
            this.bookmarks.add(new Bookmark(urlObj));
        } else {
            bookmark.addRate();
        }
    }

    public Long countSecureBookmarks() {
        return this.bookmarks.stream().filter(bookmark -> bookmark.url.isUrlSecure()).count();
    }

    public void refreshAssociates() {
        this.bookmarks.forEach(thisBookmark -> bookmarks.stream()
                .filter(bookmark -> !bookmark.url.givenUrl.equals(thisBookmark.url.givenUrl)).forEach(thisBookmark::associateBookmark));
    }

    public List<Bookmark> filterBookmarks(String keyword) {
        ArrayList<Bookmark> filteredBookmarks = new ArrayList<>();
        bookmarks.forEach(bookmark -> {
            if (bookmark.url.givenUrl.contains(keyword)) {
                filteredBookmarks.add(bookmark);
            }
        });
        return filteredBookmarks;
    }

    public List<Bookmark> filterBookmarksByMultipleKeywords(String[] keywords) {
        ArrayList<Bookmark> filteredBookmarks = new ArrayList<>();
        Arrays.stream(keywords).forEach(keyword -> filterBookmarks(keyword).forEach(bookmark -> {
            if (filteredBookmarks.stream().noneMatch(thisBookmark -> thisBookmark == bookmark)) {
                filteredBookmarks.add(bookmark);
            }
        }));
        return filteredBookmarks;
    }
}
