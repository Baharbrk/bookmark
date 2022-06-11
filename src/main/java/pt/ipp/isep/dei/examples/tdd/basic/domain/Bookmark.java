package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Bookmark {

    public Url url;
    public Integer rate = 0;
    public ArrayList<Bookmark> associatedBookmarks = new ArrayList<>();

    public Bookmark(Url url) {
        this.addUrl(url); // change this
    }

    public boolean addUrl(Url url) {
        if (url.validateUrl()) {
            this.url = url;
        }

        return false;
    }

    public void addRate() {
        this.rate++;
    }

    public String getHostName() {
        URI uri;
        String hostname = "";
        try {
            uri = new URI(this.url.url);
            hostname = uri.getHost();

            if (hostname != null) {
                return hostname.startsWith("www.") ? hostname.substring(4) : hostname;
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return hostname;
    }

    public ArrayList<Bookmark> associateBookmark(Bookmark bookmark) {
        String thisHostName = this.getHostName();
        String bookmarkHostname = bookmark.getHostName();
        if (thisHostName.equals(bookmarkHostname)) {
            this.associatedBookmarks.add(bookmark);
        }

        return this.associatedBookmarks;
    }
}
