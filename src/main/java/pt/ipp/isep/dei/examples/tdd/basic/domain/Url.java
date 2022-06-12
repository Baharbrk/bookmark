package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Url {

    public String givenUrl;
    public List<Tag> tags = new ArrayList<>();

    public Url(String url) {
        this.givenUrl = url;
    }

    public boolean validateUrl()
    {
        String urlPattern = "^(https?|ftp|file)://[-a-zA-ZäöüÄÖÜß0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.givenUrl);

        return matcher.matches();
    }

    public boolean isUrlSecure() {
        String search = "HTTPS";

        return this.givenUrl.toLowerCase().contains(search.toLowerCase());
    }

    public void tagUrl(Tag tag) {
        this.tags.add(tag);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
    }
}
