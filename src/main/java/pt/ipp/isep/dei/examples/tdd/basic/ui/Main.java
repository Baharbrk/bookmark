package pt.ipp.isep.dei.examples.tdd.basic.ui;

import pt.ipp.isep.dei.examples.tdd.basic.domain.Bookmark;
import pt.ipp.isep.dei.examples.tdd.basic.domain.Url;

import java.util.ArrayList;

public class Main {

    public ArrayList<Bookmark> bookmarks = new ArrayList<Bookmark>();

    public static void main(String[] args) {

    }
    public void bookmarkUrl(String url) {
        Bookmark bookmark = bookmarks.stream().filter(obj -> obj.url.url == url).findFirst().orElse(null);
        if (bookmark == null) {
            Url urlObj = new Url(url);
            this.bookmarks.add(new Bookmark(urlObj));
        } else {
            bookmark.addRate();
        }
    }
}
