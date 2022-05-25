package pt.ipp.isep.dei.examples.tdd.basic.domain;

public class Bookmark {

    public Url url;
    public Integer rate = 0;

    public Bookmark(Url url) {
        this.addUrl(url);
    }

    public boolean addUrl(Url url) {
        if (url.validateUrl()) {
            this.url = url;
            return true;
        }

        return false;
    }

    public void addRate() {
        this.rate++;
    }
}
